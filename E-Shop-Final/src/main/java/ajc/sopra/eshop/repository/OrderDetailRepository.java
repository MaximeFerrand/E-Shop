package ajc.sopra.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

}
