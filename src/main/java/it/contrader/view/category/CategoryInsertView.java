package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import java.sql.Date;

public class CategoryInsertView extends AbstractView{
	   private Request request;
	   
	   private String name;
	   private String description;
	   private Date date;
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
		   System.out.println("Inserisci descrizione della categoria;");
		   description = getInput();
		   System.out.println("Inserisci data:");
		   date = Date.valueOf(getInput());
		   System.out.println("Inserisci valutazione:");
		   rating = Integer.parseInt(getInput());
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
	   
	
	


