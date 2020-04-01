package it.contrader.controller;

import java.util.List;

import it.contrader.service.WishListService;
import it.contrader.dto.WishListDTO;
import it.contrader.main.MainDispatcher;

public class WishListController implements Controller {
	
	private static String sub_package = "wishlist.";
	
	private WishListService wishlistService;
	
	public WishListController() 
	{
		this.wishlistService = new WishListService();
	}
	
	@Override
	public void doControl(Request request) 
	{
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		String name;
		String description;
		
		switch(mode) 
		{
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			WishListDTO wishlistDTO = wishlistService.read(id);
			request.put("wishlist",wishlistDTO);
			MainDispatcher.getInstance().callView(sub_package + "WishListRead", request);
			break;
			
			
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			
			WishListDTO wishlistToInsert = new WishListDTO(name, description);
			
			wishlistService.insert(wishlistToInsert);
			
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "WishListInsert", request);
			break;
			
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			wishlistService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "WishListDelete", request);
			break;
			
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();
			WishListDTO wishlistToUpdate = new WishListDTO(name, description);
			wishlistToUpdate.setId(id);
			wishlistService.update(wishlistToUpdate);
			
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package +"WishListUpdate" , request);;
			break;
			
			
		case "WISHLISTS":
			List<WishListDTO> wishlistsDTO = wishlistService.getAll();
			request.put("wishlists", wishlistsDTO);
			MainDispatcher.getInstance().callView("WishList", request);
			
			break;
			
			
			//Reindirizzamento alla view specifica per ogni operazione con request nulla
		case "GETCHOICE":
			switch(choice.toUpperCase())
			{
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "WishListRead" , null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "WishListInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "WishListUpdate" , null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "WishListDelete" , null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}

}
