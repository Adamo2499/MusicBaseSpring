package musicbase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Albums {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, message = "Nazwa albumu musi mieć min. 3 znaki")
	private String name;

	@Pattern(regexp = "^.*\\.(jpg|JPG|png|PNG)$", message = "Plik musi być w formacie jpg lub png")
	private String coverimage;

	@NotNull
	private Integer publishingyear;

	public Albums() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCoverimage() {
		return coverimage;
	}

	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}

	public Integer getPublishingyear() {
		return publishingyear;
	}

	public void setPublishingyear(Integer publishingyear) {
		this.publishingyear = publishingyear;
	}

}
