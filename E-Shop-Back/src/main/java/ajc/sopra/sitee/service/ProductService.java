package ajc.sopra.sitee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.IdException;
import ajc.sopra.sitee.exception.OrderException;
import ajc.sopra.sitee.exception.ProductException;
import ajc.sopra.sitee.model.Product;
import ajc.sopra.sitee.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product findById(Integer id) {
		
		/*return produitRepo.findByIdproduitRepo(id).orElseThrow(()->{
			throw new IdException();		});*/
		return productRepo.findById(id).orElseThrow(IdException::new);
	}

	/*public List<Order> findByLibelle(String libelle) {
		return orderRepo.findByLibelleContaining(libelle);
	}*/

	public Product create(Product product) {
		if (product.getId() != null) {
			throw new OrderException("produit  deja dans la base");
		}
		return save(product);

	}

	public Product update(Product product) {
		if (product.getId() == null || !productRepo.existsById(product.getId())) {
			throw new IdException();
		}
		
		
		return save(product);
	}

	public Product save(Product product) {
		/*if (order.getLibelle() == null || order.getLibelle().isBlank() || order.getLibelle().length() > 30) {
			throw new ProduitException("probleme libelle");
		}
		*/
		if(product.getLabel()==null) {
			throw new ProductException(" Le label  du produit n'est pas renseigné !!");
		}
		if(product.getStock()==null) {
			throw new ProductException(" Le stock de produits disponibles   n'est pas renseigné !!");
		}
		if(product.getPrice()==null) {
			throw new ProductException(" Le prix  du produit n'est pas renseignée !!");
		}
		if(product.getMeasure()==null) {
			throw new ProductException(" La mesure   du produit n'est pas renseignée !!");
		}
		if(product.getReference()==null) {
			throw new ProductException(" La Reference   du produit n'est pas renseignée !!");
		}
		if(product.getDescription()==null) {
			throw new ProductException(" La Description   du produit n'est pas renseignée !!");
		}
		return productRepo.save(product);
	}

	public void delete(Product product) {
		productRepo.delete(product);
	}

	public void deleteId(Integer id) {
		productRepo.deleteById(id);
	}
}
