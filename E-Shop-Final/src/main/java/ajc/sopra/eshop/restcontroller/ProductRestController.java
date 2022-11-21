package ajc.sopra.eshop.restcontroller;

import java.lang.reflect.Field;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Product;
import ajc.sopra.eshop.model.Supplier;
import ajc.sopra.eshop.service.CategoryService;
import ajc.sopra.eshop.service.ProductService;
import ajc.sopra.eshop.service.SupplierService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins= {"*"})
public class ProductRestController {
	@Autowired
	private ProductService productSrv;
	@Autowired
	private SupplierService supplierSrv;
	@Autowired
	private CategoryService categorySrv;

	//ok
	@GetMapping("")

	@JsonView(JsonViews.ProductWithSupplierAndCatAndOD.class)
	//@JsonView(JsonViews.ProductWithSupplier.class)
	public List<Product> findAll() {
		return productSrv.findAll();
	}

	//ok
	//@JsonView(JsonViews.Common.class)
	@JsonView(JsonViews.ProductWithSupplierAndCatAndOD.class)
	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id) {
		return productSrv.findById(id);
	}
	
	//recherche par label ?
	
	//ok

	@JsonView(JsonViews.ProductWithSupplierAndCatAndOD.class)
	@PostMapping("")
	public Product create(@Valid @RequestBody Product product, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		//a mettre dans le service ?
		if (product.getSupplier() != null && product.getSupplier().getId() != null) {
			product.setSupplier(supplierSrv.findById(product.getSupplier().getId()));
		}
		if (product.getCategory() != null && product.getCategory().getId() != null) {
			product.setCategory(categorySrv.findById(product.getCategory().getId()));
			product.getCategory().getProducts().add(product);
			categorySrv.save(product.getCategory());
		}
		return productSrv.create(product);
	}

	//ok
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			productSrv.deleteId(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}

	//ok
	@PutMapping("/{id}")

	@JsonView(JsonViews.ProductWithSupplierAndCatAndOD.class)
	public Product update(@Valid @RequestBody Product product, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		product.setId(id);
		return productSrv.update(product);
	}

	//ok
	@PatchMapping("/{id}")

	@JsonView(JsonViews.ProductWithSupplierAndCatAndOD.class)
	//@JsonView(JsonViews.ProductWithSupplier.class)
	public Product update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Product product = productSrv.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("supplier")) {
				Map<String, Object> map = (Map<String, Object>) v;
				product.setSupplier(supplierSrv.findById(Integer.parseInt(map.get("id").toString())));
			} 
			else if (k.equals("category")) {
				Map<String, Object> map = (Map<String, Object>) v;
				product.setCategory(categorySrv.findByIdFetchProduits(Integer.parseInt(map.get("id").toString())));
			} else {
				Field field = ReflectionUtils.findField(Product.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, product, v);
			}
		});

		return productSrv.update(product);
	}
	@JsonView(JsonViews.searchProduct.class)
	

	
	@GetMapping("/triCroisantPrice/nom")
	public List<Product> RechercheCroissantPrice(@PathVariable String nom) {

		return productSrv.findAllByPriceAsc(categorySrv.findByLabelCat(nom).getProducts());

	}

	@GetMapping("/triCroisantLabel/nom")
	public List<Product> RechercheCroissantLabel(@PathVariable String nom) {

		return productSrv.findAllByLabelAsc(categorySrv.findByLabelCat(nom).getProducts());

	}

	@GetMapping("/triDecroissantPrice/nom")
	public List<Product> RechercheDecoissantPrice(@PathVariable String nom) {

		return productSrv.findAllByPriceDESC(categorySrv.findByLabelCat(nom).getProducts());

	}
	/*@JsonView(JsonViews.ProductWithcat.class)
	@GetMapping("/toto")
	public List<Product> findByCategoryyy(@RequestParam("lab") String lab) {
		
		return   productSrv.findByCategory(lab);}*/
	@JsonView(JsonViews.searchProduct.class)
	@GetMapping("/search/{libelle}")
	public List<Product> search(@PathVariable(name="libelle") String name) {
		return productSrv.getProductsByName(name);}
	

	@JsonView(JsonViews.ProductWithcat.class)
	@GetMapping("/toto/{catpro}")
	public List<Product> findByCategoryyy(@PathVariable(name="catpro") String name) {
		return   productSrv.findByCategory(name);}
	
	@JsonView(JsonViews.ProducAsc.class)
	@GetMapping("/tri")
	public List<Product> orderByAscendingg(){
		return   productSrv.orderByAscending();}
	
	@JsonView(JsonViews.ProducDesc.class)
	@GetMapping("/tri/Desc")
	public List<Product> orderByDescendingg(){
		return   productSrv.orderByDescending();}
	
	@JsonView(JsonViews.ProducNom.class)
	@GetMapping("/triAlpha")
	public List<Product> orderByname(){
	return   productSrv.orderBynom();}
	
	@JsonView(JsonViews.Productkey.class)
	@GetMapping("/tri/{keyss}")
	public List<Product> findByKeywordsInnn(@PathVariable(name="keyss")String name){
	return   productSrv.findByKeywordsInn(name);}

@JsonView(JsonViews.Productbetween.class)
@GetMapping("/tri/{value1}-{value2}")
public List<Product> findByPricee(@PathVariable Double value1,@PathVariable  Double value2){
	return   productSrv.findByPrice(value1,value2);}
}

