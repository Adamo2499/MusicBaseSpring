package musicbase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import musicbase.models.Song;

public interface SongsRepository extends JpaRepository<Song, Long> {

}
