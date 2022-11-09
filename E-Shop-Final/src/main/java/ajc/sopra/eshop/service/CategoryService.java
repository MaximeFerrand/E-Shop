package ajc.sopra.eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.CategoryException;
import ajc.sopra.eshop.exception.IdException;
import ajc.sopra.eshop.model.Category;
import ajc.sopra.eshop.repository.CategoryRepository;
import ajc.sopra.eshop.repository.ProductRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
    private ProductRepository productRepo;
	
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	public Optional<Category> findById(Integer id) {
		 
		return categoryRepo.findById(id);//.orElseThrow(IdException::new);
	}

	public Category create(Category category) {
		if (category.getId() != null) {
			throw new CategoryException("Category deja dans la base");
		}
		return save(category);

	}

	public Category update(Category category) {
		if (category.getId() == null || !categoryRepo.existsById(category.getId())) {
			throw new IdException();
		}
		if(category.getLabelCat()==null) {
			throw new CategoryException(" Le label de la categorie n'est pas renseigne !!");
		}
		return save(category);
	}

	public Category save(Category category) {
		
		return categoryRepo.save(category);
	}

	public void delete(Category category) {
		categoryRepo.delete(category);
	}

	public void deleteId(Integer id) {
		categoryRepo.deleteById(id);
	}
	public Category findByIdFetchProduits(Integer id) {
		return categoryRepo.findByIdFetchingProduct(id).orElseThrow(IdException::new);
	}
	
	
	public Category findByLabelCat(String labelCat) {
	return categoryRepo.findByLabelCatContaining(labelCat);
			}
}
