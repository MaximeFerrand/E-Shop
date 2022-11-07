package ajc.sopra.eshop.restcontroller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.sitee.model.JsonViews;
import ajc.sopra.sitee.model.Product;
import ajc.sopra.sitee.service.ProductService;
import ajc.sopra.sitee.service.SupplierService;



public class ProductRestController {
	@Autowired
	private ProductService productSrv;
	@Autowired
	private SupplierService supplierSrv;
	@GetMapping("")
	@JsonView(JsonViews.ProductWithSupplier.class)
	public List<Product> findAll() {
		return productSrv.findAll();
	}
	@JsonView(JsonViews.ProductWithSupplier.class)
	public Product create(@Valid @RequestBody Product product, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		if (product.getSupplier() != null && product.getSupplier().getId() != null) {
			product.setSupplier(supplierSrv.findById(product.getSupplier().getId()));
		}
//		produit = produitSrv.create(produit);
//		return produitSrv.findById(produit.getId());
		return productSrv.create(product);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			productSrv.deleteId(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
		@PutMapping("/{id}")
		@JsonView(JsonViews.ProductWithSupplier.class)
		public Product update(@Valid @RequestBody Product product, BindingResult br, @PathVariable Integer id) {
			if (br.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
			}
			product.setId(id);
			return productSrv.update(product);
		}
		@PatchMapping("/{id}")
		@JsonView(JsonViews.ProductWithSupplier.class)
		public Product update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
			Product produit = productSrv.findById(id);

			fields.forEach((k, v) -> {
				if (k.equals("supplier")) {
					Map<String, Object> map = (Map<String, Object>) v;
					product.setSupplier(supplierSrv.findById(Integer.parseInt(map.get("id").toString())));
				} else {
					Field field = ReflectionUtils.findField(Produit.class, k);
					ReflectionUtils.makeAccessible(field);
					ReflectionUtils.setField(field,product, v);
				}
			});

			return productSrv.update(product);
		
	

}


}
