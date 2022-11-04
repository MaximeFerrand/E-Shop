package ajc.sopra.sitee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.model.Review;
import ajc.sopra.sitee.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;


	public Review save(Review review) {
		return reviewRepo.save(review);
	}

	public List<Review> saveAll(List<Review> review) {
		return reviewRepo.saveAll(review);
	}

	public List<Review> findAll() {
		return reviewRepo.findAll();
	}
}
