package ajc.sopra.sitee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.IdException;
import ajc.sopra.sitee.exception.OrderException;
import ajc.sopra.sitee.model.Order;
import ajc.sopra.sitee.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	public Order findById(Integer id) {
		
		
		return orderRepo.findById(id).orElseThrow(IdException::new);
	}

	/*public List<Order> findByLibelle(String libelle) {
		return orderRepo.findByLibelleContaining(libelle);
	}*/

	public Order create(Order order) {
		if (order.getId() != null) {
			throw new OrderException("commande deja dans la base");
		}
		return save(order);

	}

	public Order update(Order order) {
		if (order.getId() == null || !orderRepo.existsById(order.getId())) {
			throw new IdException();
		}
		return save(order);
	}

	public Order save(Order order) {
		/*if (order.getLibelle() == null || order.getLibelle().isBlank() || order.getLibelle().length() > 30) {
			throw new ProduitException("probleme libelle");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("probleme prix");
		}*/
		return orderRepo.save(order);
	}
	public List<Order> saveAll(List<Order> orders) {
		return orderRepo.saveAll(orders);
	}

	public void delete(Order order) {
		orderRepo.delete(order);
	}

	public void deleteId(Integer id) {
		orderRepo.deleteById(id);
	}
}
