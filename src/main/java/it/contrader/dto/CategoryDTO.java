package it.contrader.dto;

public class CategoryDTO {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String date;
	
	private int rating;
	
	private String tags;
	
public CategoryDTO() {
		
	}

	public CategoryDTO (String name, String description, String date, int rating, String tags) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.rating = rating;
		this.tags = tags;
	}

	public CategoryDTO (int id, String name, String description, String date, int rating, String tags) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.rating = rating;
		this.tags = tags;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + description + "\t" + date + "\t" + rating + "\t" + tags;
	}
}
