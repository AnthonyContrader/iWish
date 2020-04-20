package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishListDTO {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private UserDTO proprietario;

}
