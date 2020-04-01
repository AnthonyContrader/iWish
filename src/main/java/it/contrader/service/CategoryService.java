package it.contrader.service;

import java.util.List;


import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryDAO;
import it.contrader.dto.CategoryDTO;


//il compito del service è fare il tramite tra controller e DAO
//prima chiamo DAO e converter specifici,creo oggetto DAO e oggetto converter
//e li uso per ottenere tutti gli oggetti che mi interessano e li converto in DTO (stringa)



public class CategoryService {
	
		private CategoryDAO categoryDAO;
		private CategoryConverter categoryConverter;
		
	
		public CategoryService(){
			this.categoryDAO = new CategoryDAO();
			this.categoryConverter = new CategoryConverter();
		}
		

		public List<CategoryDTO> getAll() {
		
			return categoryConverter.toDTOList(categoryDAO.getAll());
		}


		public CategoryDTO read(int id) {
			
			return categoryConverter.toDTO(categoryDAO.read(id));
		}


		public boolean insert(CategoryDTO dto) {
			
			return categoryDAO.insert(categoryConverter.toEntity(dto));
		}


		public boolean update(CategoryDTO dto) {
			
			return categoryDAO.update(categoryConverter.toEntity(dto));
		}


		public boolean delete(int id) {
		
			return categoryDAO.delete(id);
		}
		
	
	

}
