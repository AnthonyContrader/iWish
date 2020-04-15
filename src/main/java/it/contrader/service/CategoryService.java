package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

@Service
public class CategoryService extends AbstractService<Category, CategoryDTO> {
	
	@Autowired
	private CategoryConverter converter;
	@Autowired
	private CategoryRepository repository;
	
	public CategoryDTO findByAttributes(String name, String description, int rating) {
		return converter.toDTO(repository.findByAttributes(name, description, rating));
	}

}
