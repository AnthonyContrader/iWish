package it.contrader.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Progress {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;



@Column (nullable = false)
private float cash;
@Column (nullable = false)
private double expectation;
@Column (nullable = false)
private double time;
 @OneToOne(cascade=CascadeType.MERGE)
 @JoinColumn(
		 name="prodotto_id",referencedColumnName="id"// nome della foreign key e colonna a cui fa riferimento 
		 
		 )
 
 
 private Prodotto prodotto;

}
