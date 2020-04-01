package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ProdottoDTO;
import it.contrader.main.MainDispatcher;

public class ProdottoView extends AbstractView {

	private Request request;
	private String choice;
	
	public ProdottoView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione prodotti ----------------\n");
			System.out.println("ID\tName\tDescrizione\tPrezzo\tPriorità");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ProdottoDTO> prodotti = (List<ProdottoDTO>) request.get("prodotti");
			for (ProdottoDTO p: prodotti)
				System.out.println(p);
			System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("             Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi, [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Prodotto", "doControl", this.request);
	}

}
