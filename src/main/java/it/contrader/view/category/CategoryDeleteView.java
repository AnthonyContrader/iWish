package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public CategoryDeleteView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Category", null);
	
	}

}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id della categoria:");
			id = Integer.parseInt(getInput());
}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}


}
