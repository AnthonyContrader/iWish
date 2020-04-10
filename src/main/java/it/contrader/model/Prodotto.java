package it.contrader.model;

public class Prodotto {

	private int id;
	
	private String name;
	
	private String description;
	
	private float price;
	
	private int priority;
	
	private String proprietario;
	
	private Integer id_categoria_fk;
	
	private Integer id_whishlist_fk;
		
	public Prodotto() {
		
	}
	
	public Prodotto (String name, String description, float price, int priority, String proprietario) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
	}
	
	public Prodotto (int id, String name, String description, float price, int priority, String proprietario) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
	}
	
	public Prodotto (int id, String name, String description, float price, int priority, String proprietario, Integer id_categoria_fk, Integer id_whishlist_fk) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
		this.id_categoria_fk = id_categoria_fk;
		this.id_whishlist_fk = id_whishlist_fk;
	}
	
	public Prodotto (String name, String description, float price, int priority, String proprietario, Integer id_categoria_fk, Integer id_whishlist_fk) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.priority = priority;
		this.proprietario = proprietario;
		this.id_categoria_fk = id_categoria_fk;
		this.id_whishlist_fk = id_whishlist_fk;
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
		return id + "\t" + name + "\t\t" + description + "\t\t" + price + "\t\t" + priority +"\t\t" + proprietario + "\t\t" + id_categoria_fk + "\t\t" + id_whishlist_fk;
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
		if (id_categoria_fk != other.id_categoria_fk)
			return false;
		if (id_whishlist_fk != other.id_whishlist_fk)
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
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		return true;
	}
	
}
