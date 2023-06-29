package musicbase.models;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3,message="Nazwa artysty musi się składać z minium 3 znaków")
	private String name;
	
	@Size(min=3,message="Opis artysty musi się składać z minium 3 znaków")
	private String description;
	
	@URL
	private String ofc_website;
	
	@NotNull
	private String type;
	

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getOfc_website() {
		return ofc_website;
	}
	public void setOfc_website(String ofc_website) {
		this.ofc_website = ofc_website;
	}
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}