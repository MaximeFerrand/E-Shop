package ajc.sopra.eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.Artisan;
import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Supplier;
import ajc.sopra.eshop.service.ArtisanService;

@RestController
@RequestMapping("/api/artisan")
public class ArtisanRestController {

	@Autowired
	private ArtisanService artisanSrv;

	//ok
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Artisan> findAll() {
		return artisanSrv.findAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Artisan findById(@PathVariable Integer id) {
		return artisanSrv.findById(id);
	}

	//a verifier quand produits en bdd
	@JsonView(JsonViews.ArtisanWithProduit.class)
	@GetMapping("/{id}/product")
	public Artisan findByIdWithProduit(@PathVariable Integer id) {
		return artisanSrv.findByIdFetchProduits(id);
	}

	//ok
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Artisan create(@Valid @RequestBody Artisan artisan, BindingResult br) {
		//solution temporaire voir ligne 16 class Artisan "Artisan"
		if (artisan.getTypeOfSupplier()==null || artisan.getTypeOfSupplier().isEmpty()) {
			artisan.setTypeOfSupplier("Artisan");
		}
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return artisanSrv.save(artisan);
	}

	//ok
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Artisan update(@Valid @RequestBody Artisan artisan, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && artisanSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return artisanSrv.save(artisan);
	}

	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Artisan patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Artisan artisan = artisanSrv.findById(id);
		fields.forEach((k, v) -> {
			
				Field field = ReflectionUtils.findField(Artisan.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, artisan, v);
			
		});
		return artisanSrv.save(artisan);
	}

	//ok
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		artisanSrv.deleteById(id);
	}
}
