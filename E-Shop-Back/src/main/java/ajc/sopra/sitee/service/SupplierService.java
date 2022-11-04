package ajc.sopra.sitee.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.SupplierException;
import ajc.sopra.sitee.model.Supplier;
import ajc.sopra.sitee.repository.ProductRepository;
import ajc.sopra.sitee.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepo;
	@Autowired
	private ProductRepository productRepo;

	public List<Supplier> findAll() {
		return supplierRepo.findAll();

	}

	public Optional<Supplier> findByIdFetchProduits(Integer id) {
		return supplierRepo.findByIdFetchingProduits(id);//.orElseThrow(IdException::new);
	}

	public Optional<Supplier> findById(Integer id) {
		return supplierRepo.findById(id);//.orElseThrow(IdException::new);
	}

	public Supplier save(Supplier supplier) {
		if (supplier.getLogin() == null || supplier.getLogin().isBlank()) {
			throw new SupplierException();
		}
		if (supplier.getCompany() == null || supplier.getCompany().isBlank()) {
			throw new SupplierException();
		}

		return supplierRepo.save(supplier);
	}

	/*public void deleteById(Integer id) {
		productRepo.deleteBySupplier(findById(id));
		supplierRepo.deleteById(id);
	}*/
}
