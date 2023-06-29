package musicbase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicbase.models.Albums;
import musicbase.repositories.AlbumsRepository;

@Service
public class AlbumsService {
	@Autowired
	public AlbumsRepository repository;

	public <S extends Albums> S save(S entity) {
		return repository.save(entity);
	}

	public List<Albums> findAll() {
		return repository.findAll();
	}

	public Optional<Albums> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
}
