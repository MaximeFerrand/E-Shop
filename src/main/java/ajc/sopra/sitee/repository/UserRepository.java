package ajc.sopra.sitee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.sitee.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
