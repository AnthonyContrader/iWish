package it.contrader.dto;

public class CategoryDTO {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int rating;
	
	private String proprietario_c;
	
public CategoryDTO() {
		
	}

	public CategoryDTO (String name, String description, int rating, String proprietario_c) {
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.proprietario_c = proprietario_c;
	}

	public CategoryDTO (int id, String name, String description, int rating, String proprietario_c) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.proprietario_c = proprietario_c;
	}
	
	public CategoryDTO (int id, String name, String description, int rating) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getProprietario_c() {
		return proprietario_c;
	}

	
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + description + "\t" + rating + "\t" + proprietario_c;
	}
}
