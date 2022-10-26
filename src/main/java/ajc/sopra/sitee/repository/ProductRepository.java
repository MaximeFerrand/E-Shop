package ajc.sopra.sitee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.sitee.model.Admin;
import ajc.sopra.sitee.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
