package ajc.sopra.eshop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ajc.sopra.eshop.model.Achat;
import ajc.sopra.eshop.model.Client;
import ajc.sopra.eshop.model.Produit;
import ajc.sopra.eshop.service.AchatService;
import ajc.sopra.eshop.service.ClientService;
import ajc.sopra.eshop.service.ProduitService;

@Controller
@RequestMapping("/achat")
public class AchatController {

	@Autowired
	private ProduitService produitSrv;
	@Autowired
	private ClientService clientSrv;
	@Autowired
	private AchatService achatSrv;

	@GetMapping("")
	public String produitDispo(Model model) {
		model.addAttribute("produits", produitSrv.findAll());
		return "achat/produit";
	}

	@GetMapping("/panier/add/{id}")
	public String ajoutPanier(@PathVariable Integer id, Model model, HttpSession session) {
		if (session.getAttribute("panier") == null) {
			// on a pas encore de panier
			// List<ElementPanier>
			// ElementPanier=>class{ Produit, Quantite }
			// Map<Produit,Integer>
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		Produit produit = produitSrv.findById(id);
		if (panier.containsKey(produit)) {
			panier.put(produit, panier.get(produit) + 1);
		} else {
			panier.put(produit, 1);
		}
		return "redirect:/achat";
	}

	@GetMapping("/panier/delete/{id}")
	public String retirerProduitDuPanier(@PathVariable Integer id, Model model, HttpSession session) {
		Produit produit = produitSrv.findById(id);
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		if (panier.get(produit) > 1) {
			panier.put(produit, panier.get(produit) - 1);
		} else {
			panier.remove(produit);
		}
		return "redirect:/achat";
	}

	@GetMapping("/panier/validate")
	public String validationPanier(Model model) {
		model.addAttribute("clients", clientSrv.findAll());
		model.addAttribute("client", new Client());
		return "achat/validate";
	}

	@PostMapping("/save")
	public String enregistrementAchatComplet(@ModelAttribute Client client, HttpSession session, Model model) {
		Map<Produit, Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
		List<Achat> achats = new ArrayList<Achat>();
		panier.forEach((k, v) -> {
			achats.add(new Achat(v, client, k));
		});
		achatSrv.saveAll(achats);
		session.invalidate();
		return "home";

	}
}
