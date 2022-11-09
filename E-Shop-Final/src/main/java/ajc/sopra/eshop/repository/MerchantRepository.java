package ajc.sopra.eshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.eshop.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{

	@Query("select f from Merchant f left join fetch f.products where f.id=:id")
	Optional<Merchant> findByIdFetchingProducts(@Param("id") Integer id);
}
