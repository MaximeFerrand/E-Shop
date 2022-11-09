package ajc.sopra.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
