package it.contrader.dto;

public class CategoryDTO {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int rating;
	
public CategoryDTO() {
		
	}

	public CategoryDTO (String name, String description, int rating) {
		this.name = name;
		this.description = description;
		this.rating = rating;
		
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

	
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + description + "\t" + rating;
	}
}
