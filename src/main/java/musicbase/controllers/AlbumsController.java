package musicbase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import musicbase.models.Album;
import musicbase.services.AlbumsService;

@Controller
public class AlbumsController {
	
	@Autowired
	private AlbumsService service;

	public AlbumsController() {
		super();
	}

	@RequestMapping("/albums/list")
	public String viewalbumsList(Model model) {
		List<Album> lalbums = service.findAll();
		model.addAttribute("albums", lalbums);
		return "/albums/list";
	}

	@RequestMapping("/albums/new")
	public String showFormNewAlbums(Model model) {
		Album newAlbum = new Album();
		model.addAttribute("album", newAlbum);
		return "/albums/new";
	}

	@PostMapping(value = "/albums/save")
	public String saveAlbums(@ModelAttribute("albums") Album Album) {
		Album.setCoverimage(Album.getName().toLowerCase()+".jpg");
		service.save(Album);
		return "redirect:/albums/list";
	}

	@RequestMapping("/albums/edit/{id}")
	public ModelAndView showEditFormAlbums(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/albums/edit");
		Optional<Album> eAlbum = service.findById(id);
		mav.addObject("album", eAlbum);
		return mav;
	}

	@RequestMapping("/albums/show/{id}")
	public ModelAndView showAlbumDetails(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/albums/show");
		Optional<Album> showAlbum = service.findById(id);
		mav.addObject("album",showAlbum);
		return mav;
	}


	@RequestMapping("/albums/delete/{id}")
	public String deleteAlbums(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/albums/list";
	}
}
