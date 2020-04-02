package it.contrader.view.progress;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProgressDeleteView extends AbstractView{
	private Request request;
	
	private int id;
	private String mode = "DELETE";
	
	public ProgressDeleteView() {
		
	}
	// se la request non è nulla mostra l'esito dell'operazione
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Progress", null);
			
			
	     }
	}
	
	// chiede all'utente di inserire l'id da cancellare
		
	@Override
	public void showOptions() {
		System.out.println("inserisci l'id del progresso");
		id = Integer.parseInt(getInput());
	}
	
	// impacchetta la request con l'id dell'utente da cancellare
    
	@Override
	public void submit() {
		request = new Request();
		request.put("id",id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Progress","doControl",request);
		
	}	
}
	

