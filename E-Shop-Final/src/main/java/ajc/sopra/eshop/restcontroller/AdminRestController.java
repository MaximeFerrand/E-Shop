package ajc.sopra.eshop.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.Admin;
import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.service.AdminService;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins= {"*"})
public class AdminRestController {

	@Autowired
	private AdminService adminSrv;
//ok
	@PostMapping("/add_admin")
	@JsonView(JsonViews.Common.class)
	public Admin add(@Valid @RequestBody Admin user, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminSrv.save(user);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Admin findById(@PathVariable Integer id) {
		return adminSrv.findById(id);
	}
//ok
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Admin> findAll() {
		return adminSrv.findAll();
	}
}
