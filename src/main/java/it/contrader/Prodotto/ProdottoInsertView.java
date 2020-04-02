package it.contrader.Prodotto;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProdottoInsertView extends AbstractView{
	private Request request;
	
	private String name;
	private String description;
	private float price;
	private int priority;
	private final String mode = "INSERT";
			
	public ProdottoInsertView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine. \n");
			MainDispatcher.getInstance().callView("Prodotto", null);
			
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci nome del prodotto:");
		name = getInput();
		System.out.println("Inserisci descrizione del prodotto:");
		description = getInput();
		System.out.println("Inserisci il prezzo del prodotto:");
		price = Float.parseFloat(getInput());
		System.out.println("Inserisci la priorità del prodotto:");
		priority = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("price", price);
		request.put("priority", priority);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
	}
	
}
