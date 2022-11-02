package ajc.sopra.sitee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.sitee.model.Admin;
import ajc.sopra.sitee.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	//List<Patient> findByPrenomAndNom(String prenom,String nom);
	//les methodes doivent renvoyer soit List<T> ici List<Patient>
	//soit Optional<T> ici Optional<Patient>
	
	//@Query permet de definir sa propre requete
	//on analyse plus le nom de la methode
	//@Query("select p from Patient p left join fetch p.visites where p.id=:id")
	//@Param substitution du parametre :id de la query
	//Optional<Patient> findByIdFetchVisites(@Param("id") Integer id);

}
