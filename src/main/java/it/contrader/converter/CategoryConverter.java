package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;
import java.sql.Date;

public class CategoryConverter {
	
	//crea un oggetto di tipo DTO e lo riempie coi campi presi dalla classe da cui lo cotruisce
	// si usa il metodo "get()" per prendere i valori dei vari attributi
	// prende gli oggetti create e li converte string-to-object e viceversa
	//ne permette la lettura
	
	public CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getDescription(), category.getDate(), category.getRating(), category.getTags());
		return categoryDTO;
	}


	
	public Category toEntity(CategoryDTO categoryDTO) {
		 Category category = new Category(categoryDTO.getId(), categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getDate(), categoryDTO.getRating(), categoryDTO.getTags() );
		return category;
	}

	public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		
		for(Category category : categoryList) {
			categoryDTOList.add(toDTO(category));
		}
		return categoryDTOList;
	}
}
