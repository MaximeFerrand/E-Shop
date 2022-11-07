package ajc.sopra.sitee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.sitee.model.Category;
import ajc.sopra.sitee.model.Product;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query("select c from Category c left join fetch c.product where c.id=:id")
	Optional<Category> findByIdFetchingProduct(@Param("id") Integer id);
	
	Category findByLabelCatContaining(String labelCat);

}
