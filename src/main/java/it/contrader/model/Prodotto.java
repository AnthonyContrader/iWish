package it.contrader.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private float price;
	
	private int priority;
	
	@Column(length = 2000000)
	private String image;
	
	@ManyToOne()
	@JoinColumn(
			name="wishlist_fk",
			referencedColumnName = "id"
			)
	private WishList wishlist;
	
	@ManyToOne()
	@JoinColumn(
			name="category_fk",
			referencedColumnName = "id"
			)
	private Category category;
	
	@ManyToOne()
	@JoinColumn(
			name="proprietario_fk",
			referencedColumnName = "username",
			nullable = false
			)
	private User proprietario;
	
	
	
	
}
