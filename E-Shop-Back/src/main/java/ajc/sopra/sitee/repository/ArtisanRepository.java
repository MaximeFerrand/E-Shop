package ajc.sopra.sitee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.sitee.model.Artisan;

public interface ArtisanRepository extends JpaRepository<Artisan, Integer>{
	
	@Query("select f from Artisan f left join fetch f.products where f.id=:id")
	Optional<Artisan> findByIdFetchingProducts(@Param("id") Integer id);
}
