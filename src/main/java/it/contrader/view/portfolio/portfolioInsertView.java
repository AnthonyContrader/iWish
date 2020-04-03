package it.contrader.view.portfolio;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class portfolioInsertView extends AbstractView {
	private Request request;

	private Float totalmoney;
	private Float revenue;
	private Float outputs;
	private final String mode = "INSERT";

	public portfolioInsertView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("portfolio", null);
		}
	}
	@Override
	public void showOptions() {
			System.out.println("Inserisci saldo dell'utente:");
			
			String totalmoneyString = getInput();
					if (totalmoneyString.contentEquals("")) {
							totalmoney = (float)0 ;
    	         }
	      else {
	      totalmoney = Float.parseFloat (totalmoneyString);
	   }
			System.out.println("Inserisci entrate dell'utente:");
           String revenueString = getInput();
			if (revenueString.contentEquals("")) {
			revenue = (float)0 ;
			}
			else {
			revenue = Float.parseFloat (revenueString);
	}
			
			System.out.println("Inserisci uscite dell'utente:");
			String outputsString = getInput();
			if (outputsString.contentEquals("")) {
				outputs = (float)0;
			
			}
			else {
				
			
			outputs = Float.parseFloat(outputsString);
			}
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("totalmoney", totalmoney);
		request.put("revenue", revenue);
		request.put("outputs", outputs);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("portfolio", "doControl", request);
	}
}
