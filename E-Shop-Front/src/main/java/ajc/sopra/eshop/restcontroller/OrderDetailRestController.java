package ajc.sopra.eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.sitee.model.JsonViews;
import ajc.sopra.sitee.model.OrderDetail;
import ajc.sopra.sitee.model.Product;
import ajc.sopra.sitee.service.OrderDetailService;
import ajc.sopra.sitee.service.ProductService;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailRestController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private ProductService productSrv;
	
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
	
	@DeleteMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			orderDetailService.deleteId(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public OrderDetail update(@Valid @RequestBody OrderDetail orderDetail, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		orderDetail.setId(id);
		return orderDetailService.update(orderDetail);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public OrderDetail update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		OrderDetail orderDetail = orderDetailService.findById(id).get();

		fields.forEach((k, v) -> {
			if (k.equals("product")) {
				Map<String, Object> map = (Map<String, Object>) v;
				orderDetail.setProduct(productSrv.findById(Integer.parseInt(map.get("id").toString())));
			} 
			else if(k.equals("review")) {
				Map<String, Object> map2 = (Map<String, Object>) v;
				orderDetail.getReview().setComment(map2.get("notation").toString());
				orderDetail.getReview().setNotation(Integer.parseInt(map2.get("notation").toString()));
			}
			
			else {
				Field field = ReflectionUtils.findField(OrderDetail.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, orderDetail, v);
			}
		});

		return orderDetailService.update(orderDetail);
	}
}


