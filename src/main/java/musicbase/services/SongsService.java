package musicbase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicbase.models.Song;
import musicbase.repositories.SongsRepository;

@Service
public class SongsService {

	@Autowired
	public SongsRepository repository;

	public <S extends Song> S save(S entity) {
		return repository.save(entity);
	}

	public List<Song> findAll() {
		return repository.findAll();
	}

	public Optional<Song> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
}
