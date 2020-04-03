package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class CategoryInsertView extends AbstractView{
	   private Request request;
	   
	   private String name;
	   private String description;
	   private String date;
	   private int rating;
	   private String tags;
	   private final String mode = "INSERT";
	   
	   
	   public CategoryInsertView() {
		    }
	   
	   @Override
	   public void showResults(Request request) {
		   if(request!= null) {
			   System.out.println("Inserimento andato a buon fine\n");
			   MainDispatcher.getInstance().callView("Category", null);
		   }
	   }
	   @Override
	   public void showOptions() {
		   System.out.println("Inserisci nome della categoria:");
		   name = getInput();
		   while (name.contentEquals("")) {
			   System.out.println("Inserire un nome per favore:");
			   name = getInput();
		   }
		   System.out.println("Inserisci descrizione della categoria;");
		   description = getInput();
		   System.out.println("Inserisci data:");
		   date = getInput();
		   System.out.println("Inserisci preferenza:");
		  // rating = Integer.parseInt(getInput());
		   String ratingString = getInput();
		    if(ratingString.equals("")) {
		    	rating = 0;
		    } else {
		    	rating = Integer.parseInt(ratingString);
		    }
		   System.out.println("Inserisci etichetta:");
		   tags = getInput();
		   
	   }
	   
	   @Override
	   public void submit() {
		   request = new Request();
		   request.put("name", name);
		   request.put("description", description);
		   request.put("date",  date);
		   request.put("rating", rating);
		   request.put("tags", tags);
		   request.put("mode", mode);
		   MainDispatcher.getInstance().callAction("Category", "doControl", request);
		   
	   }
	   
}
	   
	
	


