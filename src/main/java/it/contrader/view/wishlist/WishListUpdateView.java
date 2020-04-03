package it.contrader.view.wishlist;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
public class WishListUpdateView extends AbstractView {
	private Request request;
	
	private int id;
	private String name;
	private String description;
	private final String mode = "UPDATE";
	
	public WishListUpdateView() {}
	
	@Override
	public void showResults(Request request) 
	{
		if(request!=null)
		{
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("WishList", null);
		}
	}
	
	@Override
	public void showOptions() 
	{
		try 
		{
			System.out.println("Inserisci l'id della wish list:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome della wish list:");
			name = getInput();
			System.out.println("Inserisci la descrizione della wish list:");
			description = getInput();
			
		}catch(Exception e) {}
	}
	
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("WishList", "doControl", request);
	}
}
