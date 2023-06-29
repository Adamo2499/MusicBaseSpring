package musicbase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicbase.models.Artist;
import musicbase.repositories.ArtistRepository;

@Service
public class ArtistService {
	@Autowired
	private ArtistRepository repository;

	public ArtistService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public <S extends Artist> S save(S entity) {
		return repository.save(entity);
	}

	public List<Artist> findAll() {
		return repository.findAll();
	}

	public Optional<Artist> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
}
