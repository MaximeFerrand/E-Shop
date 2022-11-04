package ajc.sopra.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("")
	public String form() {
		return "exoLogin/form";
	}

	@PostMapping("")
	public String bonjour(@RequestParam(name = "login", required = false) String login, Model model) {
		if (login == null || login.isBlank()) {
			model.addAttribute("error", true);
			return "exoLogin/form";
		}
		model.addAttribute("login", login);
		return "exoLogin/bonjour";
	}
}
