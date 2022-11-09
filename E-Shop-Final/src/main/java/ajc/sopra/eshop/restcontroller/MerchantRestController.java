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
import ajc.sopra.eshop.model.Merchant;
import ajc.sopra.eshop.service.MerchantService;

@RestController
@RequestMapping("/api/merchant")
public class MerchantRestController {

	@Autowired
	private MerchantService merchantSrv;

	//ok
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Merchant> findAll() {
		return merchantSrv.findAll();
	}

	//ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Merchant findById(@PathVariable Integer id) {
		return merchantSrv.findById(id);
	}

	
	@JsonView(JsonViews.MerchantWithProduit.class)
	@GetMapping("/{id}/produit")
	public Merchant findByIdWithProduit(@PathVariable Integer id) {
		return merchantSrv.findByIdFetchProduits(id);
	}

	//ok
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Merchant create(@Valid @RequestBody Merchant merchant, BindingResult br) {
		//solution temporaire voir ligne 16 class Merchant "Merchant"
		if (merchant.getTypeOfSupplier()==null || merchant.getTypeOfSupplier().isEmpty()) {
			merchant.setTypeOfSupplier("Merchant");
		}
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return merchantSrv.save(merchant);
	}

	//ok
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Merchant update(@Valid @RequestBody Merchant merchant, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && merchantSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return merchantSrv.save(merchant);
	}

	//ok
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Merchant patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Merchant merchant = merchantSrv.findById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Merchant.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, merchant, v);
		
	});
		return merchantSrv.save(merchant);
	}

	//ok
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		merchantSrv.deleteById(id);
	}
}
