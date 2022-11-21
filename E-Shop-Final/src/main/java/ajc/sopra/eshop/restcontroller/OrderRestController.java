package ajc.sopra.eshop.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
//import com.mysql.cj.xdevapi.Client;

import ajc.sopra.eshop.model.Account;
import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Order;
import ajc.sopra.eshop.model.OrderDetail;
import ajc.sopra.eshop.model.Product;
import ajc.sopra.eshop.model.User;
import ajc.sopra.eshop.service.OrderDetailService;
import ajc.sopra.eshop.service.OrderService;
import ajc.sopra.eshop.service.ProductService;
import ajc.sopra.eshop.service.UserService;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	@Autowired
	private OrderService orderSrv;
	
	@Autowired
	private OrderDetailService orderDetailSrv;
	@Autowired
	private ProductService produitSrv;
	@Autowired
	private UserService userSrv;
	
	
	//@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductRestController.class);
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Product> produitDispo() {
		
		return produitSrv.findAll();
	}
	
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@PostMapping("")
	public Order create(@RequestBody Order order, @AuthenticationPrincipal Account account) {
		//controles
		//User user= new User(account.getLogin(), account.getPassword());
		order.setUser(userSrv.findById(account.getId()));
		return orderSrv.save(order);
	}
	
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@PostMapping("/list")
	public List<Order> create(@RequestBody List<Order> orders,@AuthenticationPrincipal Account account) {
		orders.forEach(order->{
			order.setUser(userSrv.findById(account.getId()));
		});
		return orderSrv.saveAll(orders);
	}
}



