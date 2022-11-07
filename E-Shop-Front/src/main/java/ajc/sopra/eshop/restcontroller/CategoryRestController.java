package ajc.sopra.eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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

import ajc.sopra.sitee.model.Category;
import ajc.sopra.sitee.model.JsonViews;
import ajc.sopra.sitee.model.Supplier;
import ajc.sopra.sitee.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
	@Autowired
	private CategoryService categorySrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Category> findAll() {
		return categorySrv.findAll();
	}
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Optional<Category> findById(@PathVariable Integer id) {
		return  categorySrv.findById(id);
	}
	@JsonView(JsonViews.CategoryWithProduct.class)
	@GetMapping("/{id}/produit")
	public Supplier findByIdWithProduit(@PathVariable Integer id) {
		return categorySrv.findByIdFetchProduits(id);
	}
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category create(@Valid @RequestBody Category category, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return categorySrv.save(category);
	}
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Category update(@Valid @RequestBody Category category, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && categorySrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return categorySrv.save(category);
	}
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Supplier patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Category category = categorySrv.findById(id);
		fields.forEach((k, v) -> {
			
				Field field = ReflectionUtils.findField(Category.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, category, v);
			
		});
		return categorySrv.save(category);
	}
}
