package musicbase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musicbase.models.Album;
import musicbase.repositories.AlbumsRepository;

@Service
public class AlbumsService {
	
	@Autowired
	private AlbumsRepository albumsRepository;

	public <S extends Album> S save(S entity) {
		return albumsRepository.save(entity);
	}

	public List<Album> findAll() {
		return albumsRepository.findAll();
	}

	public Optional<Album> findById(Long id) {
		return albumsRepository.findById(id);
	}

	public void deleteById(Long id) {
		albumsRepository.deleteById(id);
	}
	
	
}
