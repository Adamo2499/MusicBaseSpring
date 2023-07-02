package musicbase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="songs", schema="musicbase")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "Tytuł jest za krótki")
	private String title;
	
	@NotNull
	@Positive
	private Integer performer_id;
	
	@NotNull
	@Positive(message = "Indeks albumu musi być liczbą dodatnią!")
	private Integer album_id;
	
	@NotNull
	@Pattern(regexp = "^[0-5]{1}\\:[0-5]{1}[0-9]{1}$", message = "Nieprawidłowo zapisana długość utworu!")
	private String duration;

	public Song() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPerformer() {
		return performer_id;
	}

	public void setPerformer(Integer performer) {
		this.performer_id = performer;
	}

	public Integer getAlbumid() {
		return album_id;
	}

	public void setAlbumid(Integer albumid) {
		this.album_id = albumid;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
		
}
