package it.contrader.view.progress;

import it.contrader.controller.Request;

import it.contrader.dto.ProgressDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ProgressReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";

	public ProgressReadView() {
	}
	
	@Override
	public void showResults (Request request) {
		if (request!= null) {
			ProgressDTO progress =(ProgressDTO) request.get("progress");
			System.out.println(progress);
			MainDispatcher.getInstance().callView("Progress",null);
		}
	}
     // chiede all'utente di inserire l'id dell'utente da leggere
	@Override
	public void showOptions() {
		System.out.println("inserisci l'ID del Progresso");
		id= Integer.parseInt(getInput());
		
	}
	
	@Override
	public void submit() {
		request =new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Progress", "doControl", request);
	}
	
}
