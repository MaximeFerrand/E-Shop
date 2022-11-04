package ajc.sopra.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/home") // par defaut la requete est en get
	public String home() {
		return "home";
	}

	@RequestMapping(path = "/home/maison", method = RequestMethod.GET)
	public String autreHome() {
		return "home";
	}

	//@XXXMapping =>XXX method à utlisier
	@GetMapping("/home2")
	public String encoreHome() {
		return "home";
	}
}
