package ajc.sopra.sitee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.sitee.model.Admin;
import ajc.sopra.sitee.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
