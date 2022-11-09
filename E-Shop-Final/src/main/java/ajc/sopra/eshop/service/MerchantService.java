package ajc.sopra.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.ArtisanException;
import ajc.sopra.eshop.exception.IdException;
import ajc.sopra.eshop.model.Merchant;
import ajc.sopra.eshop.repository.MerchantRepository;
import ajc.sopra.eshop.repository.ProductRepository;

@Service
public class MerchantService {

	@Autowired
	private MerchantRepository merchantRepo;
	
	@Autowired
	private ProductRepository productRepo;

	public List<Merchant> findAll() {
		return merchantRepo.findAll();
	}


	public Merchant findByIdFetchProduits(Integer id) {
		return merchantRepo.findByIdFetchingProducts(id).orElseThrow(IdException::new);
	}

	public Merchant findById(Integer id) {
		return merchantRepo.findById(id).orElseThrow(IdException::new);
	}

	public Merchant save(Merchant merchant) {
		if (merchant.getCompany() == null || merchant.getCompany().isBlank()) {
			throw new ArtisanException();
		}
	
		return merchantRepo.save(merchant);
	}

	public void deleteById(Integer id) {
		//productRepo.deleteByMerchant(findById(id));
		merchantRepo.deleteById(id);
	}
}
