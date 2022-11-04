package ajc.sopra.sitee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.sitee.exception.IdException;
import ajc.sopra.sitee.model.Admin;
import ajc.sopra.sitee.repository.AdminRepository;



@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;

	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	public Admin findById(Integer id) {
		return adminRepo.findById(id).orElseThrow(IdException::new);
	}

	public Admin save(Admin client) {
		return adminRepo.save(client);
	}
	
}
