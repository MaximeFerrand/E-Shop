package ajc.sopra.eshop.EShopFinal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import ajc.sopra.eshop.model.Product;
import ajc.sopra.eshop.service.OrderService;
import ajc.sopra.eshop.service.ProductService;

@ExtendWith(SpringExtension.class)
@Transactional
//par defaut rollback a la fin de chaque transaction
class OrderServiceTest {

	@Autowired
	OrderService orderSrv;
	@Test
	void InjectionProduitServicetest() {
		assertNotNull(orderSrv);
	}
	@Autowired
	ProductService pros;
	/*@Test
	@Commit
	@Disabled
	void initProduit() {
		productSrv.create(new Produit("velo", 100, null));
		productSrv.create(new Produit("voiture", 200, null));
	}

	@Test
	void creationProduitTest() {
		Produit produit = new Produit("aaa", 1.5, null);
		produit = produitSrv.create(produit);
		assertNotNull(produit.getId());
		assertNotNull(produitSrv.findById(produit.getId()));
	}*/
	/*List<Product> searchResults= pros.getProductsBy("lit");
	searchResults.forEach(product -> System.out.println(product.getLabel()));	
	
}	*/
}
