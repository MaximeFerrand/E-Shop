package ajc.sopra.sitee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.CategoryException;
import ajc.sopra.sitee.exception.IdException;
import ajc.sopra.sitee.model.Category;
import ajc.sopra.sitee.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	public Optional<Category> findById(Integer id) {
		
		/*return produitRepo.findByIdproduitRepo(id).orElseThrow(()->{
			throw new IdException();		});*/
		return categoryRepo.findById(id);//.orElseThrow(IdException::new);
	}

	/*public List<Order> findByLibelle(String libelle) {
		return orderRepo.findByLibelleContaining(libelle);
	}*/

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

	private Category save(Category category) {
		/*if (order.getLibelle() == null || order.getLibelle().isBlank() || order.getLibelle().length() > 30) {
			throw new ProduitException("probleme libelle");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("probleme prix");
		}*/
		return categoryRepo.save(category);
	}

	public void delete(Category category) {
		categoryRepo.delete(category);
	}

	public void deleteId(Integer id) {
		categoryRepo.deleteById(id);
	}
}
