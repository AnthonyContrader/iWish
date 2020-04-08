package it.contrader.dto;

public class ProdottoDTO {

	private int id;
	
	private String name;
	
	private String description;
	
	private Float price;
	
	private Integer priority;
	
	public ProdottoDTO() {
		
	}
	
	public ProdottoDTO (String name, String description, Float price, Integer priority) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
	}
	
	public ProdottoDTO (int id, String name, String description, Float price, Integer priority) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t\t" + description + "\t\t" + price + "\t\t" + priority;
	}
	
	}

