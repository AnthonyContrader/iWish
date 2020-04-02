package it.contrader.Prodotto;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProdottoUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private String description;
	private float price;
	private int priority;
	private final String mode = "UPDATE";
	
	public ProdottoUpdateView() {
}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Prodotto", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del prodotto:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del prodotto:");
			name = getInput();
			System.out.println("Inserisci costo del prodotto:");
			price = Float.parseFloat(getInput());
			System.out.println("Inserisci la priorità del prodotto:");
			priority = Integer.parseInt(getInput());
		} catch (Exception e) {
			
		}
	}	
		
		@Override
		public void submit() {
			request = new Request();
			request.put("id", id);
			request.put("name", name);
			request.put("description", description);
			request.put("price", price);
			request.put("priority", priority);
	}
}
