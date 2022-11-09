package ajc.sopra.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Admin;
import ajc.sopra.eshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
