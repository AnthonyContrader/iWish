package it.contrader.view.wishlist;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class WishListDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public WishListDeleteView() {}
	
	@Override
	public void showResults(Request request) 
	{
		if(request!=null)
		{
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("WishList", null);
		}
		
	}

}
