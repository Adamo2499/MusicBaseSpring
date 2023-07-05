package musicbase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import musicbase.models.Artist;
import musicbase.services.ArtistService;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistService service;

	public ArtistController() {
		super();
	}

	@GetMapping("/artists/list")
	public String viewArtistsList(Model model) {
		List<Artist> lArtists = service.findAll();
		model.addAttribute("artists", lArtists);
		return "/artists/list";
	}

	@GetMapping("/artists/new")
	public String showFormNewArtist(Model model) {
		Artist newArtist = new Artist();
		model.addAttribute("artist", newArtist);
		return "/artists/new";
	}

	@PostMapping(value = "/artists/save")
	public String saveArtist(@ModelAttribute("artist") Artist artist) {
		service.save(artist);
		return "redirect:/artists/list";
	}

	@GetMapping("/artists/edit/{id}")
	public ModelAndView showEditFormArtist(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/artists/edit");
		Optional<Artist> eartist = service.findById(id);
		mav.addObject("artist", eartist);
		return mav;
	}
	
	@GetMapping("/artists/show/{id}")
	public ModelAndView showArtist(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/artists/show");
		Optional<Artist> sartist = service.findById(id);
		mav.addObject("artist", sartist);
		return mav;
	}
	
	@GetMapping("/artists/details/{id}")
	public ModelAndView showArtistDetails(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/artists/details");
		Optional<Artist> artistDetails = service.findById(id);
		mav.addObject("artist", artistDetails);
		return mav;
	}

	@DeleteMapping("/artists/delete/{id}")
	public String deleteArtist(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/artists/list";
	}
}
