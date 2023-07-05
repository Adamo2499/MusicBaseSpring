package musicbase.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import musicbase.models.Album;
import musicbase.models.Artist;
import musicbase.models.Song;
import musicbase.services.AlbumsService;
import musicbase.services.ArtistService;
import musicbase.services.SongsService;

@Controller
public class SongsController {
	
	@Autowired
	private SongsService service;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private AlbumsService albumsService;
	

	public SongsController() {
		super();
	}

	@GetMapping("/songs/list")
	public String viewSongsList(Model model) {
		List<Song> songsList = service.findAll();
		model.addAttribute("songs", songsList);
		return "/songs/list";
	}

	@GetMapping("/songs/new")
	public String showFormNewSongs(Model model) {
		Song newSong = new Song();
		List<Artist> artistsList = artistService.findAll();
		List<Album> albumsList = albumsService.findAll();
		model.addAttribute("artists",artistsList);
		model.addAttribute("albums",albumsList);
		model.addAttribute("song", newSong);
		return "/songs/new";
	}

	@PostMapping(value = "/songs/save")
	public String saveSongs(@ModelAttribute("Songs") Song Songs) {
		service.save(Songs);
		return "redirect:/songs/list";
	}

	@GetMapping("/songs/edit/{id}")
	public ModelAndView showEditFormSongs(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("/songs/edit");
		Optional<Song> songToEdit = service.findById(id);
		mav.addObject("song", songToEdit);
		return mav;
	}
	@DeleteMapping("/songs/delete/{id}")
	public String deleteSongs(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		return "redirect:/songs/list";
	}
}
