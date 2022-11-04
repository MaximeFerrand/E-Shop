package ajc.sopra.sitee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.sitee.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("select c from Category c left join fetch c.product where c.id=:id")
	Optional<Category> findByIdFetchingProduct(@Param("id") Integer id);

}
