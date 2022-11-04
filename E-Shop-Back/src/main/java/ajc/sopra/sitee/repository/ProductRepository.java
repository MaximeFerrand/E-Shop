package ajc.sopra.sitee.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.sitee.model.Admin;
import ajc.sopra.sitee.model.Artisan;
import ajc.sopra.sitee.model.Merchant;
import ajc.sopra.sitee.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	
<<<<<<< Updated upstream
	@Transactional
	@Modifying
	@Query("delete from Product p where p.artisan=:artisan")
	int deleteByArtisan(@Param("artisan") Artisan artisan);

	@Transactional
	@Modifying
	@Query("delete from Product p where p.merchant=:merchant")
	int deleteByMerchant(@Param("merchant") Merchant merchant);
=======
	@Query("delete from Product p where p.supplier=:supplier")
	int deleteBySupplier(@Param("supplier") Supplier supplier);

>>>>>>> Stashed changes

}
