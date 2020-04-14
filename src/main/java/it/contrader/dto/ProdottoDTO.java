package it.contrader.dto;

import it.contrader.model.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdottoDTO {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private float price;
	
	private int priority;

}
