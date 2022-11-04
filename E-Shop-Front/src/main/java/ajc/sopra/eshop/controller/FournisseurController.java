package ajc.sopra.eshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ajc.sopra.eshop.model.Fournisseur;
import ajc.sopra.eshop.service.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurSrv;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("fournisseurs", fournisseurSrv.findAll());
		return "fournisseur/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		fournisseurSrv.deleteById(id);
		return "redirect:/fournisseur";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Fournisseur());
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Integer id) {
		return goEdit(model, fournisseurSrv.findById(id));
	}
	
	private String goEdit(Model model,Fournisseur fournisseur) {
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/edit";
	}
	
	@PostMapping("")
	public String save(@Valid @ModelAttribute Fournisseur fournisseur,BindingResult br,Model model) {
		System.out.println(br);
		if(br.hasErrors()) {
			return goEdit(model, fournisseur);
		}
		fournisseurSrv.save(fournisseur);
		return "redirect:/fournisseur";
	}
	
}
