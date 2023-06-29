package musicbase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import musicbase.models.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
