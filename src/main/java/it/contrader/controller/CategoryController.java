package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategoryService;
import java.sql.Date;

//ha compito di collegare l'app alla view
//invocano il service per inviare dati alla view tramite request
// implements evoca una interfaccia specifica per usare i metodi di quella classe

public class CategoryController implements Controller {
	

		
		private static String sub_package = "category.";
		
		//crea oggetto service per chiamarne i servizi (inserisci,leggi,update,...)
		
		private CategoryService categoryService;

	
		public CategoryController() {
			this.categoryService = new CategoryService();
		}
		
		@Override
		public void doControl(Request request) {
			
			//mode ti da possibilita di scelta tra le azioni
			//choice ti da la possibilità di navigare all'interno dell'app tramite determinati comandi
			
			String mode = (String) request.get("mode");			
			String choice = (String) request.get("choice");
			
			int id;
			String name;
			String description;
			Date date;
			int rating;
			String tags;

			switch (mode) {
			
			case "READ":
				id = Integer.parseInt(request.get("id").toString());
				CategoryDTO categoryDTO = categoryService.read(id);
				request.put("category", categoryDTO);
				MainDispatcher.getInstance().callView(sub_package + "CategoryRead", request);
				break;
			
			
			case "INSERT":
				name = request.get("name").toString();
				description = request.get("description").toString();
				date = Date.valueOf(request.get("date").toString());
				rating =Integer.parseInt(request.get("rating").toString());
				tags = request.get("tags").toString();
				
				
				CategoryDTO categorytoinsert = new CategoryDTO(name, description, date, rating, tags);
				categoryService.insert(categorytoinsert);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", request);
				break;
			
			case "DELETE":
				id = Integer.parseInt(request.get("id").toString());
				categoryService.delete(id);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", request);
				break;
			
			case "UPDATE":
				id = Integer.parseInt(request.get("id").toString());
				name = request.get("name").toString();
				description = request.get("description").toString();
				date = Date.valueOf(request.get("date").toString());
				rating = Integer.parseInt(request.get("rating").toString());
				tags = request.get("tags").toString();
				CategoryDTO categorytoupdate = new CategoryDTO(name, description, date, rating, tags);
				categorytoupdate.setId(id);
				categoryService.update(categorytoupdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", request);
				break;
				
			case "CATEGORYLIST":
				List<CategoryDTO> categoriesDTO = categoryService.getAll();
				request.put("categories", categoriesDTO);
				MainDispatcher.getInstance().callView("Category", request);
				break;
		
				
			case "GETCHOICE":
						
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "CategoryRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;

				case "B":
					MainDispatcher.getInstance().callView("HomeAdmin", null);
					break;
					
				default:
					MainDispatcher.getInstance().callView("Login", null);
				}
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		}
	}



