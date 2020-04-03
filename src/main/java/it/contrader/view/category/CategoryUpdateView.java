package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import java.sql.Date;

public class CategoryUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private String description;
	private Date date;
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
			date = Date.valueOf(getInput());
			System.out.println("Inserisci valutazione:");
			rating = Integer.parseInt(getInput());
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

