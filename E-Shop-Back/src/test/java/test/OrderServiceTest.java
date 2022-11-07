package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import ajc.sopra.sitee.config.JpaConfig;
import ajc.sopra.sitee.service.OrderService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
//par defaut rollback a la fin de chaque transaction
class OrderServiceTest {

	@Autowired
	OrderService orderSrv;
	@Test
	void InjectionProduitServicetest() {
		assertNotNull(orderSrv);
	}
	
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

}
