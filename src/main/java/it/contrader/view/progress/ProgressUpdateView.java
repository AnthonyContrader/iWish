package it.contrader.view.progress;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProgressUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private float cash;
	private double expectation;
	private double time;
	private final String mode = "UPDATE";
	
	public ProgressUpdateView() {
		
	}
    
	@Override
	public void showResults (Request request) {
		if (request!=null) {
		System.out.println("Modifica andata a buon fine.\n");
		MainDispatcher.getInstance().callView("Progress", null);
		}
	}

   // si chiedono gli attributi da modificare
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del progresso:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il saldo dell'utente:");
		    cash = Float.parseFloat(getInput());
			System.out.println("Inserisci il prospetto dell'utente:");
			expectation = Double.parseDouble(getInput());
			System.out.println("Inserisci tempo dell'utente:");
			String timeString= getInput();
			if (timeString.equals("")) {
				time=0;
			}
			else {
			time=Double.parseDouble(timeString);
			}
			//time = Double.parseDouble(getInput());
		} catch (Exception e){

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("cash", cash);
		request.put("expectation", expectation);
		request.put("time", time);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Progress", "doControl", request);
	}

}
