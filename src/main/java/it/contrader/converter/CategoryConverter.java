package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

public class CategoryConverter implements Converter<Category, CategoryDTO> {
	
	 @Override
	 public CategoryDTO toDTO(Category category) {
		 CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getDescription(), category.getRating());
		 return categoryDTO;
		 
	 }

	 @Override
	 public Category toEntity(CategoryDTO categoryDTO) {
		 Category category = new Category (categoryDTO.getId(), categoryDTO.getName(), categoryDTO.getDescription(), categoryDTO.getRating());
		 return category;
	 }
	 
	 @Override
	 public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		 
		 List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		 for(Category category: categoryList) {
			 categoryDTOList.add(toDTO(category));
		 }
		 return categoryDTOList;
		 }
	 }
	 

