package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PortfolioDTO {
	
	private Long id;

	private float totalmoney;

	private float revenue;
	
	private float outputs;
	
	private UserDTO proprietario;

	
}
