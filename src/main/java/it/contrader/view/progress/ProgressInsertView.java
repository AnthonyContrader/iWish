package it.contrader.view.progress;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProgressInsertView extends AbstractView {
	private Request request;
	
	private float cash;
	private double expectation;
	private double time;
	private final String mode = "INSERT";
	
	public ProgressInsertView() {
		
	}

	// se la request non è nulla mostra l'esito dell'operazione
	
	@Override
	public void showResults(Request request){
		if(request!=null) {
			System.out.println("inserimento andato a buon fine.\n ");
			MainDispatcher.getInstance().callView("Progress", null);
		}
	}
	
	//chiede all'utente cosa inserire 
	@Override
	public void showOptions() {
		System.out.println("inserisci il Saldo:");
		cash=Float.parseFloat(getInput());
		System.out.println("inserisci la Proiezione");
		expectation=Double.parseDouble(getInput());
		System.out.println("inserisci il Tempo");
		time=Double.parseDouble(getInput());
	}

    @Override
    public void submit() {
    	request = new Request();
    	request.put("cash", cash);
    	request.put("expectation",expectation);
    	request.put("time",time);
    	request.put("mode",mode);
    	MainDispatcher.getInstance().callAction("Progress","doControl",request);
    }
}
