package it.contrader.model;

import java.sql.Date;

public class Category {
	
    // qui ci vanno gli attributi di Category
	// in private poichè chiamabili solo dalla classe stessa?
	
	private int id;	
	private Date date;	
	private String name;	
	private String description;	
	private int rating;	
	private String tags;
	
	// Qui ci vanno i costruttori il primo è di default
	//i costruttori permettono di definire oggetti che vengono chiamati tramite l'uso di "this."
	
	public Category() {
		
	}
	
	public Category (String name, String description, Date date, int rating, String tags) {
	     this.name = name;
	     this.description = description;
	     this.date = date;
	     this.rating = rating;
	     this.tags = tags;
	}
	
	public Category (int id, String name, String description, Date date, int rating, String tags ) {
		 this.id = id;
		 this.name = name;
	     this.description = description;
	     this.date = date;
	     this.rating = rating;
	     this.tags = tags;
	}
	
	//getter e setter sono i modificatori utilizzati dalle altre classi
	// per recuperare gli attributi di questa classe
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}


	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
		public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
			return this.date;
		}
	//trasforma oggetto in stringa per vedere tutto nel complesso
	// "\t" sta per tabulatore serve a inserire spazi
	@Override
	public String toString() {
		return  id + "\t" + name + "\t" + description +"\t\t" + date + "\t" + rating +"\t" + tags;
	}
	
	//Confrontiamo gli oggetti
	//la prima parte confronta se ci sono oggetti nel campo?
	// consideriamo che verranno inseriti oggetti chiamati "other" che dovranno essere confrontati con gli oggetti esistenti
	//per poter essere chiamati
	// le stringhe possono essere non esistenti, vuote o sbagliate
	//  gli altri tipi di dati  possono solo essere identici o no
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (date != other.date)
			return false;
		if (name == null) {
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
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
	

}


