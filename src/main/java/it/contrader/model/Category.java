package it.contrader.model;

public class Category {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int rating;
		
	
	public Category() {
		
	}

	 public Category (String name, String description, int rating) {
		this.name = name;
		this.description = description;
		this.rating = rating;
		
	 }
	 
	 public Category (int id, String name, String description, int rating) {
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

	public String toString() {
		return id + "\t" + name + "\t" + description + "\t" + rating;
		
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
		if(id != other.id)
			return false;
		if(name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
				if (rating != other.rating)
			return false;
		return true;
	
		}
    }
	