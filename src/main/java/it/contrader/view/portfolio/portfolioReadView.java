package it.contrader.view.portfolio;

import it.contrader.controller.Request;


import it.contrader.dto.portfolioDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class portfolioReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";

	public portfolioReadView() {
	}
	
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			portfolioDTO Portfolio = (portfolioDTO) request.get("Portfolio");
			System.out.println(Portfolio);
			MainDispatcher.getInstance().callView("portfolio", null);
		}

}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
	    request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("portfolio", "doControl", request);
	}

}
	
	
	
	