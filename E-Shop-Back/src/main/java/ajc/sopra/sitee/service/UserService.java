package ajc.sopra.sitee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.model.User;
import ajc.sopra.sitee.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(Integer id) {
		return userRepo.findById(id).orElseThrow(IdException::new);
	}

	public User save(User client) {
		return userRepo.save(client);
	}
}
