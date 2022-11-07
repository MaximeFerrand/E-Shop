package ajc.sopra.sitee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.ArtisanException;
import ajc.sopra.sitee.exception.IdException;
import ajc.sopra.sitee.model.Merchant;
import ajc.sopra.sitee.repository.MerchantRepository;
import ajc.sopra.sitee.repository.ProductRepository;

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
