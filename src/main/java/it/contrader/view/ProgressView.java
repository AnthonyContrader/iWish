package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ProgressDTO;
import it.contrader.main.MainDispatcher;

// alla view arrivano solo oggetti di tipo DTO
public class ProgressView extends AbstractView{
	
	private Request request;
	private String choice;
	
	//costruttori
	public ProgressView() {
			
	}
	
	//mostra i progressi 
	
	@Override
	public void showResults(Request request) {
		if ( request!= null) {
		System.out.println("\n-----------****-The Progress Are-****-----------\n");
		System.out.println("id\tCash\t     Expectation\tTime");
		System.out.println("------------------------------------------------");
	
	@SuppressWarnings("unchecked")
	List<ProgressDTO> progressi = (List<ProgressDTO>) request.get("progress");
	for (ProgressDTO p : progressi)
		System.out.println(p);
	System.out.println();
			
		}
	}

	 // chiede all'utente una lettera da tastiera per scegliere
	@Override
	public void showOptions() {
		System.out.println("-----------Scegli l'operazione da effettuare-----------");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice= getInput();
		
		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode","GETCHOICE");
		MainDispatcher.getInstance().callAction("Progress","doControl", this.request);
		
		
		
	}
	
}
