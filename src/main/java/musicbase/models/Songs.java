package musicbase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Songs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "Tytuł jest za krótki")
	private String title;
	
	@NotNull
	@Positive
	private Integer performer;
	
	@NotNull
	@Positive(message = "Indeks albumu musi być liczbą dodatnią!")
	private Integer albumid;
	
	@NotNull
	@Pattern(regexp = "^[0-5]{1}\\:[0-5]{1}[0-9]{1}$", message = "Nieprawidłowo zapisana długość utworu!")
	private String duration;

	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPerformer() {
		return performer;
	}

	public void setPerformer(Integer performer) {
		this.performer = performer;
	}

	public Integer getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
		
}
