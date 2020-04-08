package it.contrader.model;

public class Prodotto {

	private int id;
	
	private String name;
	
	private String description;
	
	private float price;
	
	private int priority;
	
	public Prodotto() {
		
	}
	
	public Prodotto (String name, String description, float price, int priority) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
	}
	
	public Prodotto (int id, String name, String description, float price, int priority) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@Override
	
	public String toString() {
		return id + "\t" + name + "\t\t" + description + "\t\t" + price + "\t\t" + priority;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
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
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}
}
