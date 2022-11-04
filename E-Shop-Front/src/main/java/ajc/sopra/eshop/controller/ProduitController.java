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
import org.springframework.web.bind.annotation.RequestParam;

import ajc.sopra.eshop.model.Produit;
import ajc.sopra.eshop.service.FournisseurService;
import ajc.sopra.eshop.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitSrv;
	@Autowired
	private FournisseurService fournisseurSrv;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitSrv.findAll());
		return "produit/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goForm(produitSrv.findById(id), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Produit(), model);
	}

	private String goForm(Produit produit, Model model) {
		model.addAttribute("produit", produit);
		model.addAttribute("fournisseurs", fournisseurSrv.findAll());
		return "produit/edit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		produitSrv.deleteId(id);
		return "redirect:/produit";
	}

	@PostMapping("")
	public String save(@Valid @ModelAttribute Produit produit, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goForm(produit, model);
		}
		if (produit.getId() == null) {
			produitSrv.create(produit);
		} else {
			produitSrv.update(produit);
		}
		return "redirect:/produit";
	}
}
