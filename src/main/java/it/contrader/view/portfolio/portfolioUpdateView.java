package it.contrader.view.portfolio;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class portfolioUpdateView extends AbstractView {

	private Request request;

	private int id;
	private Float totalmoney;
	private Float revenue;
	private Float outputs;
	private final String mode = "UPDATE";

	public portfolioUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("portfolio", null);
		}
	}

	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'utente:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci saldo dell'utente:");
			totalmoney = Float.parseFloat(getInput());
			System.out.println("Inserisci entrate dell'utente:");
			revenue = Float.parseFloat(getInput());
			System.out.println("Inserisci uscite dell'utente:");
			outputs = Float.parseFloat(getInput());
		} catch (Exception e) {
		
		}

		}
		
		@Override
		public void submit() {
			request = new Request();
			request.put("id", id);
			request.put("totalmoney", totalmoney);
			request.put("revenue", revenue);
			request.put("outputs", outputs);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("portfolio", "doControl", request);
		}

	}
