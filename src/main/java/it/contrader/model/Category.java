package it.contrader.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "proprietario_c",
        referencedColumnName = "username"
      )
	@OnDelete(action = OnDeleteAction.CASCADE)
    private User proprietario_c;
	
	
			}
