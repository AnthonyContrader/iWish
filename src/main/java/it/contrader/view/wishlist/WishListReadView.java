package it.contrader.view.wishlist;

import it.contrader.controller.Request;
import it.contrader.dto.WishListDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class WishListReadView extends AbstractView {
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public WishListReadView() {}
	
	@Override
	public void showResults(Request request)
	{
		if(request!=null)
		{
			WishListDTO wishlist = (WishListDTO) request.get("wishlist");
			System.out.println(wishlist);
			MainDispatcher.getInstance().callView("WishList", null);
		}
	}
	
	@Override
	public void showOptions() 
	{
		System.out.println("Inserisci l'id della wish list: ");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("WishList", "doControl", request);
	}
	
}
