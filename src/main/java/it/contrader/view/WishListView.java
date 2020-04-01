package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.WishListDTO;
import it.contrader.main.MainDispatcher;

public class WishListView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public WishListView() {}
	
	/**
	 * Mostra lista di WishLists
	 */
	@Override
	public void showResults(Request request)
	{
		if(request!=null)
		{
			System.out.println("\n------- Gestione delle WishLists -------\n");
			System.out.println("ID\tName\tDescription");
			System.out.println("------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<WishListDTO> wishlists = (List<WishListDTO>) request.get("wishlists");
			for(WishListDTO wl: wishlists)
			{
				System.out.println(wl);
			}
			System.out.println();
			
		}
	}
	
	/**
	 * Menu e input da tastiera per la scelta(choice)
	 */
	@Override
	public void showOptions() 
	{
		System.out.println("   Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput();
	}
	
	/**
	 * Impacchetta la request e la manda alla WishListController
	 */
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("WishList", "doControl", this.request);
	}
	
	
	
	

}
