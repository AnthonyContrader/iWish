package it.contrader.controller;

import java.util.List;


import it.contrader.dto.portfolioDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.portfolioService;



public class portfolioController implements Controller {
	
private static String sub_package = "Portfolio.";
	
	private portfolioService PortfolioService;
	
	public portfolioController() {
		this.PortfolioService = new portfolioService();
	}
	
	@Override
	
public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		Float totalmoney;
		Float revenue;
		Float outputs;

		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			portfolioDTO PortfolioDTO = PortfolioService.read(id);
			request.put("Portfolio", PortfolioDTO);
			MainDispatcher.getInstance().callView(sub_package + "portfolioRead", request);
			break;
	
			
		case "INSERT":
			
			totalmoney = Float.parseFloat(request.get("totalmoney").toString());
			revenue = Float.parseFloat(request.get("revenue").toString());
			outputs = Float.parseFloat(request.get("uoutputs").toString());
			
			portfolioDTO Portfoliotoinsert = new portfolioDTO(totalmoney, revenue, outputs);
			//invoca il service
			PortfolioService.insert(Portfoliotoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "portfolioInsert", request);
			break;
			
			// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
			case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			PortfolioService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "portfolioDelete", request);
			break;
			
			
			case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			totalmoney = Float.parseFloat(request.get("totalmoney").toString());
			revenue = Float.parseFloat(request.get("revenue").toString());
			outputs = Float.parseFloat(request.get("uoutputs").toString());
			portfolioDTO Portfoliotoupdate = new portfolioDTO(totalmoney, revenue, outputs);
			Portfoliotoupdate.setId(id);
			PortfolioService.update(Portfoliotoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "portfolioUpdate", request);
			break;
			
			
			//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "PORTFOLIOLIST":
			List<portfolioDTO> PortfoliolistDTO = PortfolioService.getAll();
				//Impacchetta la request con la lista degli user
				request.put("Portfoliolist", PortfoliolistDTO);
				MainDispatcher.getInstance().callView("portfolio", request);
				break;
				
		case "GETCHOICE":
				
				//toUpperCase() mette in maiuscolo la scelta
		    switch (choice.toUpperCase()) {
		    
		    case "L":
				MainDispatcher.getInstance().callView(sub_package + "portfolioRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "portfolioInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "portfolioUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "portfolioDelete", null);
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
		    

