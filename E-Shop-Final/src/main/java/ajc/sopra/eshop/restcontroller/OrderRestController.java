package ajc.sopra.eshop.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
//import com.mysql.cj.xdevapi.Client;

import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Order;
import ajc.sopra.eshop.model.OrderDetail;
import ajc.sopra.eshop.model.Product;
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
	//ok
	/*
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@GetMapping("/panier/add/{id}")
	public Map<Product, Integer> ajoutPanier(@PathVariable Integer id, Model model, HttpSession session) {
		if (session.getAttribute("panier") == null) {
			// on a pas encore de panier
			// List<ElementPanier>
			// ElementPanier=>class{ Produit, Quantite }
			// Map<Produit,Integer>
			session.setAttribute("panier", new HashMap<Product, Integer>());
		}
		Map<Product, Integer> panier = (Map<Product, Integer>) session.getAttribute("panier");
		//Product produit = produitSrv.findById(id);
		OrderDetail orderDetail = orderDetailSrv.findById(id);
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + 1);
		} else {
			panier.put(produit, 1);
		}
		LOGGER.debug(panier.toString());
		return panier;
	}*/
	
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@GetMapping("/panier/add/{id}")
	public List<OrderDetail> ajoutPanier(@PathVariable Integer id, Model model, HttpSession session) {
		if (session.getAttribute("panier") == null) {
			// on a pas encore de panier
			// List<ElementPanier>
			// ElementPanier=>class{ Produit, Quantite }
			// Map<Produit,Integer>
			session.setAttribute("panier", new ArrayList());
		}
		List<OrderDetail> panier = (List<OrderDetail>) session.getAttribute("panier");
		//Product produit = produitSrv.findById(id);
		//OrderDetail orderDetail = orderDetailSrv.findById(id);
		for(OrderDetail d : panier) {
			if (d.getId()==id) {
				d.setQuantity(d.getQuantity()+1);
			} else {
				d.setQuantity( 1);
			}
			
		}
		
		LOGGER.debug(panier.toString());
		return panier;
	}
	//ok
	/*
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@GetMapping("/panier/delete/{id}")
	public Map<Product, Integer>  retirerProduitDuPanier(@PathVariable Integer id, Model model, HttpSession session) {
		Product produit = produitSrv.findById(id);
		Map<Product, Integer> panier = (Map<Product, Integer>) session.getAttribute("panier");
		if (panier.get(produit) > 1) {
			panier.put(produit, panier.get(produit) - 1);
		} else {
			panier.remove(produit);
		}
		return panier;
	}*/
	/*
	@JsonView(JsonViews.Common.class)

	@GetMapping("/panier/validate")
	public Model validationPanier(Model model) {
		model.addAttribute("clients", userSrv.findAll());
		model.addAttribute("client", new User());
		//return "achat/validate";
		return model;
	}*/
	@JsonView(JsonViews.Common.class)
	@PostMapping("/save")
	public void enregistrementAchatComplet(@RequestBody Order order, HttpSession session, Model model) {
		Map<Product, Integer> panier = (Map<Product, Integer>) session.getAttribute("panier");
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		order.setUser(userSrv.findById(order.getUser().getId()));
		
		panier.forEach((k, v) -> {
			order.getOrdreDetail().add(new OrderDetail(v, k));
			
		});
		
		orderSrv.save(order);
		session.invalidate();
		//return "home";

	}
}



