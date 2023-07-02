package musicbase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import musicbase.models.Album;

@Repository
public interface AlbumsRepository extends JpaRepository<Album, Long> {
}
