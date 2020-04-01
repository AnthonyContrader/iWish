package it.contrader.dto;

public class ProdottoDTO {

	private int id;
	
	private String name;
	
	private String description;
	
	private float price;
	
	private int priority;
	
	public ProdottoDTO() {
		
	}
	
	public ProdottoDTO (String name, String description, float price, int priority) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
	}
	
	public ProdottoDTO (int id, String name, String description, float price, int priority) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
	}
	
	public int getId( ) {
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
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name +"\t\t" + description + "\t\t" + price + "\t\t" + priority;
	}
}
