package ajc.sopra.eshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.eshop.model.Category;
import ajc.sopra.eshop.model.Product;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query("select c from Category c left join fetch c.products where c.id=:id")
	Optional<Category> findByIdFetchingProduct(@Param("id") Integer id);
	
	Category findByLabelcatContaining(String labelCat);

}
