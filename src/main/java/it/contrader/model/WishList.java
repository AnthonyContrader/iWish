package it.contrader.model;

public class WishList {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String proprietario;
	
	public WishList() {}
	
	public WishList(String name, String description, String proprietario) {
		this.name = name;
		this.description = description;
		this.proprietario = proprietario;
	}
	
	public WishList(int id, String name, String description, String proprietario) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.proprietario = proprietario;
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
	
	public String getProprietario() {
		return proprietario;
	}
	

	@Override
	public String toString() {
		return id + "\t" + name +"\t\t"+description+"\t\t"+ proprietario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishList other = (WishList) obj;
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
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		return true;
	}

 

	

	
	
	

}
