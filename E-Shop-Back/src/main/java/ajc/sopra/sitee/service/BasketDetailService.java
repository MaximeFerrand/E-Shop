package ajc.sopra.sitee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.model.BasketDetail;
import ajc.sopra.sitee.repository.BasketDetailRepository;

@Service
public class BasketDetailService {

	@Autowired
	private BasketDetailRepository basketDetailRepo;


	public BasketDetail save(BasketDetail basketDetail) {
		return basketDetailRepo.save(basketDetail);
	}

	public List<BasketDetail> saveAll(List<BasketDetail> basketDetail) {
		return basketDetailRepo.saveAll(basketDetail);
	}

	public List<BasketDetail> findAll() {
		return basketDetailRepo.findAll();
	}
}
