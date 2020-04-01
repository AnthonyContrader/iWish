package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.portfolioDTO;
import it.contrader.main.MainDispatcher;


public class portfolioView extends AbstractView {
	

	private Request request;
	private String choice;

	public portfolioView() {
	}
	@Override
	
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione portafoglio ----------------\n");
			System.out.println("ID\tTotalmoney\tRevenue\tOutputs");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			
			List<portfolioDTO> Portfoliolist = (List<portfolioDTO>) request.get("Portfoliolist");
			for (portfolioDTO p: Portfoliolist)
				System.out.println(p);
			System.out.println();
		}
	}
		
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
		
	}		
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("portfolio", "doControl", this.request);
		}
}

