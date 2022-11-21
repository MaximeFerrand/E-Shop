package ajc.sopra.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.IdException;
import ajc.sopra.eshop.model.User;
import ajc.sopra.eshop.repository.AccountRepository;
import ajc.sopra.eshop.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(Integer id) {
		return userRepo.findById(id).orElseThrow(IdException::new);
	}

	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	public boolean checkEmailExists(String email) {
		return accountRepo.findByLogin(email).isPresent();
	}
}
