package musicbase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import musicbase.models.Albums;

public interface AlbumsRepository extends JpaRepository<Albums, Long> {

}
