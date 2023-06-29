package musicbase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicbase.models.Songs;
import musicbase.repositories.SongsRepository;

@Service
public class SongsService {

	@Autowired
	public SongsRepository repository;

	public <S extends Songs> S save(S entity) {
		return repository.save(entity);
	}

	public List<Songs> findAll() {
		return repository.findAll();
	}

	public Optional<Songs> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
}
