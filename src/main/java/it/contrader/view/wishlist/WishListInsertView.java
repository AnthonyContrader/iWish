package it.contrader.view.wishlist;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class WishListInsertView extends AbstractView {
	private Request request;
	
	private String name;
	private String description;
	private final String mode = "INSERT";
	
	public WishListInsertView() {}
	
	@Override
	public void showResults(Request request)
	{
		if(request!=null)
		{
			System.out.println("Inserimento andato a buon fine");
			MainDispatcher.getInstance().callView("WishList", null);
		}
	}
	
	@Override
	public void showOptions()
	{
		System.out.println("Inserisci il nome della wish list:");
		
		name = getInput();
		while(name.equals("")) {
			System.out.println("Il nome è obbligatorio!");
			System.out.println("Inserisci il nome della wish list:");
			name = getInput();
		}
		System.out.println("Inserisci una descrizione della wish list");
		
		description = getInput();
		
	}
	
	@Override 
	public void submit()
	{
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("WishList", "doControl", request);
	}
}
