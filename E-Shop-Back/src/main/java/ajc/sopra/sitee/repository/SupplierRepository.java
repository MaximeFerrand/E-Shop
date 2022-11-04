package ajc.sopra.sitee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ajc.sopra.sitee.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	@Query("select s from Supplier s left join fetch s.products where s.id=:id")
	Optional<Supplier> findByIdFetchingProduits(@Param("id") Integer id);
}

