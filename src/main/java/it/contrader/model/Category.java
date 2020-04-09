package it.contrader.model;

public class Category {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int rating;
	
	private String proprietario_c;
		
	
	public Category() {
		
	}

	 public Category (String name, String description, int rating, String proprietario_c) {
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.proprietario_c = proprietario_c;
	 }
	 
	 public Category (int id, String name, String description, int rating, String proprietario_c) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.proprietario_c = proprietario_c;
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
		return id + "\t" + name +"\t\t"+description+"\t\t"+rating+"\t\t"+proprietario_c;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (proprietario_c == null) {
			if (other.proprietario_c != null)
				return false;
		} else if (!proprietario_c.equals(other.proprietario_c))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	
}