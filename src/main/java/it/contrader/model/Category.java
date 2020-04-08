package it.contrader.model;

public class Category {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String date;
	
	private int rating;
	
	private String tags;
	
	
	public Category() {
		
	}

	 public Category (String name, String description, String date, int rating, String tags) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.rating = rating;
		this.tags = tags;
	 }
	 
	 public Category (int id, String name, String description, String date, int rating, String tags) {
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
	
	public String toString() {
		return id + "\t" + name + "\t" + description + "\t" + date + "\t" + rating + "\t" + tags;
		
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (rating != other.rating)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	
		}
    }
	