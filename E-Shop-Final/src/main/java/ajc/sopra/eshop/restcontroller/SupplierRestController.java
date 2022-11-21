package ajc.sopra.eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Supplier;
import ajc.sopra.eshop.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
@CrossOrigin(origins= {"*"})
public class SupplierRestController {

	@Autowired
	private SupplierService supplierSrv;

	//ok
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Supplier> findAll() {
		return supplierSrv.findAll();
	}

	//ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Supplier findById(@PathVariable Integer id) {
		return supplierSrv.findById(id);
	}

	//a verifier quand produits en bdd
	@JsonView(JsonViews.SupplierWithProduit.class)
	@GetMapping("/{id}/produit")
	public Supplier findByIdWithProduit(@PathVariable Integer id) {
		return supplierSrv.findByIdFetchProduits(id);
	}

	//Ok
	@PostMapping("/signup")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Supplier create(@Valid @RequestBody Supplier supplier, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return supplierSrv.save(supplier);
	}

	//ok
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Supplier update(@Valid @RequestBody Supplier supplier, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && supplierSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return supplierSrv.save(supplier);
	}
	
	//ok
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Supplier patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Supplier supplier = supplierSrv.findById(id);
		fields.forEach((k, v) -> {
			
				Field field = ReflectionUtils.findField(Supplier.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, supplier, v);
			
		});
		return supplierSrv.save(supplier);
	}

	//ok
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		supplierSrv.deleteById(id);
	}
}
