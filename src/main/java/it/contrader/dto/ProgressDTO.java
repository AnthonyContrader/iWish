package it.contrader.dto;

import java.sql.Timestamp;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgressDTO {

		private Long id;
		
		private float cash;
		
		private double expectation;
		
		private double time;
		
		private ProdottoDTO prodotto; // creo una nuova variabile di tipo prodotto
		
		private Timestamp data;
}
