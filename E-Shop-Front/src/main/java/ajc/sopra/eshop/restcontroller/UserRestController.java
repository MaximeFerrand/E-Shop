package ajc.sopra.eshop.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.Client;
import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.service.ClientService;
import ajc.sopra.sitee.service.UserService;

@RestController
@RequestMapping("/api/client")
public class UserRestController {

	@Autowired
	private UserService userSrv;

	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public User inscription(@Valid @RequestBody User client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return userSrv.save(client);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		return userSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<user> findAll() {
		return userSrv.findAll();
	}
}
