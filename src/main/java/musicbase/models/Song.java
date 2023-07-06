package musicbase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

	@ManyToOne
	@JoinColumn(name = "album_id")
	private Album album;
	
	@ManyToOne
	@JoinColumn(name = "performer_id")
	private Artist performer;
	
	@NotNull
	@Pattern(regexp = "^[0-5]{1}\\:[0-5]{1}[0-9]{1}$", message = "Nieprawidłowo zapisana długość utworu!")
	private String duration;

	public Song() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public Integer getPerformer_id() {
//		return performer_id;
//	}
//
//	public void setPerformerID(Integer performer_id) {
//		this.performer_id = performer_id;
//	}
//
//	public Integer getAlbum_id() {
//		return album_id;
//	}
//
//	public void setAlbumID(Integer album_id) {
//		this.album_id = album_id;
//	}
	

	public String getDuration() {
		return duration;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artist getPerformer() {
		return performer;
	}

	public void setPerformer(Artist performer) {
		this.performer = performer;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
		
}
