package ajc.sopra.eshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ajc.sopra.eshop.model.Client;
import ajc.sopra.eshop.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientSrv;

	@GetMapping("/inscription")
	public String inscription(Model model) {
		model.addAttribute("client", new Client());
		return "client/inscription";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Client client, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "client/inscription";
		}
		clientSrv.save(client);
		return "redirect:/achat/panier/validate";
	}
}
