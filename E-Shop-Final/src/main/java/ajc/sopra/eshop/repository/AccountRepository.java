package ajc.sopra.eshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Account;


public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Optional<Account> findByLogin(String email);

}
