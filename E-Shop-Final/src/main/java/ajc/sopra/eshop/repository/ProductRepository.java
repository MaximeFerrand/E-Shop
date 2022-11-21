package ajc.sopra.eshop.repository;


import java.math.BigDecimal;
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
	 
	

	
	//List<Product> findByLabelContaining(String libelle);
	
	@Query("select p from Product p order by p.price asc")
	List<Product> selectIncreasePrice (List<Product> listeBrute);
	
	@Query("select p from Product p order by p.price  desc")
	List<Product> selectDecreasePrice (List<Product> listeBrute);
	
	@Query("select p from Product p order by p.label asc")
	List<Product> selectIncreaseLabel (List<Product> listeBrute);
	
	@Query("select p from Product p where p.price between :min and :max  ")
	List<Product> selectIntervalPrice (@Param("min")int min,@Param("max") int max);
	
	@Query("from Product order by price asc")
	public List<Product> orderByAscending();
	@Query("from Product order by price desc")
	public List<Product> orderByDescending();
	@Query("from Product order by label asc")
	public List<Product> orderByname();
	 
	@Query("SELECT p FROM Product p WHERE CONCAT(p.label, ' ', p.description, ' ', p.reference, ' ', p.measure, ' ',p.price) LIKE %?1%")

	public List<Product> findByTitleLike(String keys);
	
	@Query("from Product where price between :min and  :max")
	public List<Product> findByPrice(@Param("min") Double min, @Param("max") Double max);
	public List<Product> findByLabel(String label); 
	public List<Product> findByCategoryLabelcat(String Labelcat);
	 
	
	

}
