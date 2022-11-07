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
import ajc.sopra.sitee.model.OrderDetail;
import ajc.sopra.sitee.service.OrderDetailService;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailRestController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@JsonView(JsonViews.OrderDetailWithProduct.class)
	@PostMapping("")
	public OrderDetail create(@RequestBody OrderDetail achat) {
		//controles
		return orderDetailService.save(achat);
	}
	
	@JsonView(JsonViews.OrderDetailWithProduct.class)
	@PostMapping("/list")
	public List<OrderDetail> create(@RequestBody List<OrderDetail> achats) {
		//controles
		return orderDetailService.saveAll(achats);
	}
	
	@JsonView({JsonViews.OrderDetailWithProduct.class,JsonViews.OrderDetailWithReview.class} )
	@GetMapping("")
	public List<OrderDetail> findAll(){
		return orderDetailService.findAll();
	}
}


