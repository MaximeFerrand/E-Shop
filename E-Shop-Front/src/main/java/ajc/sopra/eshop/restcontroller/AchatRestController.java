package ajc.sopra.eshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.Achat;
import ajc.sopra.eshop.model.JsonViews;
import ajc.sopra.eshop.service.AchatService;

@RestController
@RequestMapping("/api/achat")
public class AchatRestController {

	@Autowired
	private AchatService achatService;
	
	@JsonView(JsonViews.Achat.class)
	@PostMapping("")
	public Achat create(@RequestBody Achat achat) {
		//controles
		return achatService.save(achat);
	}
	
	@JsonView(JsonViews.Achat.class)
	@PostMapping("/list")
	public List<Achat> create(@RequestBody List<Achat> achats) {
		//controles
		return achatService.saveAll(achats);
	}
	
	@JsonView(JsonViews.Achat.class)
	@GetMapping("")
	public List<Achat> findAll(){
		return achatService.findAll();
	}
}


