package it.contrader.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Portfolio {
	

	@Id
	@GeneratedValue
	
	private Long id;

	@Column(nullable = false)
	
	private float totalmoney;

	@Column(nullable = false)
	
	private float revenue;
	
	@Column(nullable = false)
	
	private float outputs;
	
	@Column(nullable = false)
	
	private Timestamp date;
	
	@OneToOne()
	@JoinColumn(
			name="proprietario",
			referencedColumnName = "username",
			nullable= false
			)
			
			private User proprietario;
	
}

