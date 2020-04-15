package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CategoryDTO;

import it.contrader.model.Category;

@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDTO> {

	  @Override
	  public Category toEntity(CategoryDTO categoryDTO) {
		  Category category = null;
		  if (categoryDTO != null) {
			  category = new Category(categoryDTO.getId(), categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getRating());
		  }
		  return category;
	  }

	  @Override
	  public CategoryDTO toDTO(Category category) {
		  CategoryDTO categoryDTO = null;
		  if (category != null) {
			  categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getDescription(), category.getRating());
		  }
		  return categoryDTO;
	  }
	   	  
	  
}
