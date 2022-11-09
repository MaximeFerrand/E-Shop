package ajc.sopra.eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.IdException;
import ajc.sopra.eshop.exception.SupplierException;
import ajc.sopra.eshop.model.Supplier;
import ajc.sopra.eshop.repository.ProductRepository;
import ajc.sopra.eshop.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepo;
	@Autowired
	private ProductRepository productRepo;

	public List<Supplier> findAll() {
		return supplierRepo.findAll();

	}

	public Supplier findByIdFetchProduits(Integer id) {
		return supplierRepo.findByIdFetchingProduits(id).orElseThrow(IdException::new);
	}

	public Supplier findById(Integer id) {
		return supplierRepo.findById(id).orElseThrow(IdException::new);
	}

	public Supplier save(Supplier supplier) {
		/*if (supplier.getLogin() == null || supplier.getLogin().isBlank()) {
			throw new SupplierException();
		}
		if (supplier.getCompany() == null || supplier.getCompany().isBlank()) {
			throw new SupplierException();
		}*/

		return supplierRepo.save(supplier);
	}

	
	
	public void deleteById(Integer id) {
		//productRepo.deleteById(findById(id));
		supplierRepo.deleteById(id);
	}
}
