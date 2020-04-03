package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class CategoryUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private String description;
	private String date;
	private int rating;
	private String tags;
	private final String mode = "UPDATE";
	
	public CategoryUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della categoria:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome della categoria:");
			name = getInput();
			System.out.println("Inserisci descrizione della categoria:");
			description = getInput();
			System.out.println("Inserisci la data:");
			date = getInput();		
			System.out.println("Inserisci valutazione:");
			String ratingString = getInput();
			if (ratingString.equals("")) {
				rating = -1;
				} else { 
			rating = Integer.parseInt(ratingString); }
			System.out.println("Inserisci etichetta:");
			tags = getInput();
		    } catch (Exception e) {

	}

}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("description", description);
		request.put("date", date);
		request.put("rating", rating);
		request.put("tags", tags);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}

}

