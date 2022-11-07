package ajc.sopra.sitee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.IdException;
import ajc.sopra.sitee.exception.OrderDetailException;
import ajc.sopra.sitee.model.OrderDetail;
import ajc.sopra.sitee.repository.OrderDetailRepository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepo;

	public List<OrderDetail> findAll() {
		return orderDetailRepo.findAll();
	}

	public Optional<OrderDetail> findById(Integer id) {
		
		/*return produitRepo.findByIdproduitRepo(id).orElseThrow(()->{
			throw new IdException();		});*/
		return orderDetailRepo.findById(id);//.orElseThrow(IdException::new);
	}

	/*public List<Order> findByLibelle(String libelle) {
		return orderRepo.findByLibelleContaining(libelle);
	}*/

	public OrderDetail create(OrderDetail orderDetail) {
		if (orderDetail.getId() != null) {
			throw new OrderDetailException("order Detail deja dans la base");
		}
		
		if(orderDetail.getQuantity()==null) {
			throw new OrderDetailException(" La quatite n'est pas renseigne !!");
		}
		return save(orderDetail);

	}

	public OrderDetail update(OrderDetail orderDetail) {
		if (orderDetail.getId() == null || !orderDetailRepo.existsById(orderDetail.getId())) {
			throw new IdException();
		}
		return save(orderDetail);
	}

	public OrderDetail save(OrderDetail orderDetail) {
		/*if (order.getLibelle() == null || order.getLibelle().isBlank() || order.getLibelle().length() > 30) {
			throw new ProduitException("probleme libelle");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("probleme prix");
		}*/
		return orderDetailRepo.save(orderDetail);
	}

	public List<OrderDetail> saveAll(List<OrderDetail> orderDetails) {
		/*if (order.getLibelle() == null || order.getLibelle().isBlank() || order.getLibelle().length() > 30) {
			throw new ProduitException("probleme libelle");
		}
		if (produit.getPrix() <= 0) {
			throw new ProduitException("probleme prix");
		}*/
		return orderDetailRepo.saveAll(orderDetails);
	}

	public void delete(OrderDetail orderDetail) {
		orderDetailRepo.delete(orderDetail);
	}

	public void deleteId(Integer id) {
		orderDetailRepo.deleteById(id);
	}
}
