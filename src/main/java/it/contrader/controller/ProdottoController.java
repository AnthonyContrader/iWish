package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ProdottoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ProdottoService;

public class ProdottoController implements Controller {

	private static String sub_package = "Prodotto.";
	
	private ProdottoService prodottoService;
	
	public ProdottoController() {
		this.prodottoService = new ProdottoService();
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String name;
		String description;
		float price;
		int priority;
		
		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			ProdottoDTO prodottoDTO = prodottoService.read(id);
			request.put("prodotto", prodottoDTO);
			MainDispatcher.getInstance().callView(sub_package + "ProdottoRead", request);
			break;
			
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			price = Float.parseFloat(request.get("price").toString());
			priority = Integer.parseInt(request.get("priority").toString());
			ProdottoDTO prodottoinsert = new ProdottoDTO(name, description, price, priority);
			prodottoService.insert(prodottoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ProdottoInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			prodottoService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ProdottoDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();
			price = Float.parseFloat(request.get("price").toString());
			priority = Integer.parseInt(request.get("priority").toString());
			ProdottoDTO prodottoupdate = new ProdottoDTO(name, description, price, priority);
			prodottoupdate.setId(id);
			prodottoService.update(prodottoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ProdottoUpdate", request);
			break;
			
		case "PRODOTTOLIST":
			List<ProdottoDTO> prodottiDTO = prodottoService.getAll();
			request.put("prodotti", prodottiDTO);
			MainDispatcher.getInstance().callView("Prodotto", request);
			break;
			
		case "GETCHOICE":
			
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ProdottoRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ProdottoInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ProdottoUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ProdottoDelete", null);
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
