package ajc.sopra.eshop.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.model.Supplier;
import ajc.sopra.eshop.model.User;
import ajc.sopra.eshop.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins= {"*"})
public class UserRestController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService userSrv;
	
	@GetMapping("/check/email/{email}")
	public boolean checkEmailExists(@PathVariable String email) {
		return userSrv.checkEmailExists(email);
	}
//ok
	@PostMapping("/signup")
	@JsonView(JsonViews.UserWithOrderAndAdress.class)
	//@JsonView({JsonViews.UserWithAdress.class,JsonViews.UserWithOrder.class})
	public User inscription(@Valid @RequestBody User user, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return userSrv.save(user);
	}
//ok
	@JsonView(JsonViews.UserWithOrderAndAdress.class)
	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		return userSrv.findById(id);
	}
	
//ok
	@JsonView(JsonViews.UserWithOrderAndAdress.class)
	@GetMapping("")
	public List<User> findAll() {
		return userSrv.findAll();
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public User update(@Valid @RequestBody User user, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && userSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return userSrv.save(user);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public User patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		User user = userSrv.findById(id);
		fields.forEach((k, v) -> {
			
				Field field = ReflectionUtils.findField(User.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, user, v);
			
		});
		return userSrv.save(user);
}
}
