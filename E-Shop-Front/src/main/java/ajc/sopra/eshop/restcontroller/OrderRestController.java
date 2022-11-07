package ajc.sopra.eshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;


import ajc.sopra.sitee.model.JsonViews;
import ajc.sopra.sitee.model.Order;
import ajc.sopra.sitee.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@JsonView({JsonViews.OrderWithOrderDetail.class, JsonViews.OrderWithUser.class})
	@PostMapping("")
	public Order create(@RequestBody Order achat) {
		//controles
		return orderService.save(achat);
	}
	
	@JsonView({JsonViews.OrderWithOrderDetail.class, JsonViews.OrderWithUser.class})
	@PostMapping("/list")
	public List<Order> create(@RequestBody List<Order> orders) {
		//controles
		return orderService.saveAll(orders);
	}
	
	@JsonView({JsonViews.OrderWithOrderDetail.class, JsonViews.OrderWithUser.class})
	@GetMapping("")
	public List<Order> findAll(){
		return orderService.findAll();
	}
}


