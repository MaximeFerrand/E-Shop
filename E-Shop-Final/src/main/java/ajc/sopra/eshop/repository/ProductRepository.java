package ajc.sopra.eshop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.eshop.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	/*@Transactional
	@Modifying
	@Query("delete from Product p where p.artisan=:artisan")
	int deleteByArtisan(@Param("artisan") Artisan artisan);

	@Transactional
	@Modifying
	@Query("delete from Product p where p.merchant=:merchant")
	int deleteByMerchant(@Param("merchant") Merchant merchant);*/
	
	/*
	@Query("delete from Product p where p.supplier=:supplier")
	int deleteBySupplier(@Param("supplier") Supplier supplier);*/
	
	List<Product> findByLabelContaining(String libelle);
	
	@Query("select p from Product p order by p.price asc")
	List<Product> selectIncreasePrice (List<Product> listeBrute);
	
	@Query("select p from Product p order by p.price  desc")
	List<Product> selectDecreasePrice (List<Product> listeBrute);
	
	@Query("select p from Product p order by p.label asc")
	List<Product> selectIncreaseLabel (List<Product> listeBrute);
	
	@Query("select p from Product p where p.price between :min and :max  ")
	List<Product> selectIntervalPrice (@Param("min")int min,@Param("max") int max);
	
	
	
	

}
