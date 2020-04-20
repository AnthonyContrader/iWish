package it.contrader.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Category {
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (nullable = false)
	private String name;
	
	private String description;
	
	int rating;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.DETACH)
    @JoinColumn(
        name = "proprietario_c",
        referencedColumnName = "username"
    )
    private User proprietario_c;
	
			}
