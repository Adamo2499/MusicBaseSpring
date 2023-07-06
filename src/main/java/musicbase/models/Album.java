package musicbase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="albums", schema="musicbase")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, message = "Nazwa albumu musi mieć min. 3 znaki")
	private String name;

	@Pattern(regexp = "^.*\\.(jpg|JPG|png|PNG)$", message = "Plik musi być w formacie jpg lub png")
	private String coverImage;

	@NotNull
	private Integer publishingYear;

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(@NotNull Long id, @NotNull String name, String coverImage, @NotNull Integer publishingYear) {
		this.id = id;
		this.name = name;
		this.coverImage = coverImage;
		this.publishingYear = publishingYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public Integer getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Integer publishingYear) {
		this.publishingYear = publishingYear;
	}
}
