package it.contrader.dto;

public class WishListDTO {
	
	private int id;
	
	private String name;
	
	private String description;

	public WishListDTO() {
	}

	public WishListDTO(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public WishListDTO(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t\t" + description;
	}
}
