package it.contrader.dto;

public class ProdottoDTO {

	private int id;
	
	private String name;
	
	private String description;
	
	private Float price;
	
	private Integer priority;
	
	private String proprietario;
	
	private Integer id_categoria_fk;
	
	private Integer id_whishlist_fk;
	
	public ProdottoDTO() {
		
	}
	
	public ProdottoDTO (String name, String description, Float price, Integer priority, String proprietario) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
	}
	
	public ProdottoDTO (int id, String name, String description, Float price, Integer priority, String proprietario) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
	}
	
	public ProdottoDTO (int id, String name, String description, Float price, Integer priority) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
	
	}
	
	public ProdottoDTO (int id, String name, String description, float price, int priority, String proprietario, Integer id_categoria_fk, Integer id_whishlist_fk) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
		this.id_categoria_fk = id_categoria_fk;
		this.id_whishlist_fk = id_whishlist_fk;
	}
	
	public ProdottoDTO (String name, String description, float price, int priority, String proprietario, Integer id_categoria_fk, Integer id_whishlist_fk) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
		this.id_categoria_fk = id_categoria_fk;
		this.id_whishlist_fk = id_whishlist_fk;
	}
	
	public ProdottoDTO (int id, String name, String description, Float price, Integer priority, Integer id_categoria_fk, Integer id_wishlist_fk) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.id_categoria_fk = id_categoria_fk;
		this.id_whishlist_fk = id_wishlist_fk;
	
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
	
	public String getProprietario() {
		return proprietario;
	}
		
	public Integer getId_categoria_fk() {
		return id_categoria_fk;
	}

	public void setId_categoria_fk(Integer id_categoria_fk) {
		this.id_categoria_fk = id_categoria_fk;
	}

	public Integer getId_whishlist_fk() {
		return id_whishlist_fk;
	}

	public void setId_whishlist_fk(Integer id_whishlist_fk) {
		this.id_whishlist_fk = id_whishlist_fk;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t\t" + description + "\t\t" + price + "\t\t" + priority +"\t\t" + proprietario +"\t\t" + id_categoria_fk + "\t\t" + id_whishlist_fk;
	}
	
	}

