package musicbase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import musicbase.models.Songs;

public interface SongsRepository extends JpaRepository<Songs, Long> {

}
