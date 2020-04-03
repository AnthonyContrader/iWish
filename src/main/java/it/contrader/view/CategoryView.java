package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;

public class CategoryView extends AbstractView {
	
	//in AbstractView abbiamo il metodo GetInput()
	//che usa un'interfaccia view che usa tre metodi:
	//showresult : mostra i dati che arrivano dal controller nella request
	//showoption : svolge il ruolo di "menù" proponendo opzioni, se vi è un input da inserire si usa "getInput()"
	//submit : prende i dati, li inserisce in una request e li manda al controller tramite il MainDispatcher
	
	private Request request;
	private String choice;
	
	public CategoryView() {
		
	}
	
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n---------Gestione categorie-----\n");
			System.out.println("ID\tname\tdescription\tdate\t\trating\ttags\n");
			System.out.println("--------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CategoryDTO> categories = (List<CategoryDTO>) request.get("categories");
			for (CategoryDTO c: categories)
				System.out.println(c);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("    Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
                      
		this.choice = getInput();
	
	
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
		
	}

	
}
