/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non � nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [C]ategory [P]rodotto [W]allet [L]istaDesideri [T]imeLine  [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() � definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sar� diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        
        case "c":
        	this.request.put("mode", "CATEGORYLIST");
        	MainDispatcher.getInstance().callAction("Category", "doControl", request);
        	break;
        
        case "p":
        	this.request.put("mode", "PRODOTTOLIST");
        	MainDispatcher.getInstance().callAction("Prodotto", "doControl", request);
        	break;
        	
        case "w":
        	this.request.put("mode", "PORTFOLIOLIST");
        	MainDispatcher.getInstance().callAction("portfolio","doControl", request);
        	break;
        
        case "l":
        	this.request.put("mode", "WISHLISTS");
        	MainDispatcher.getInstance().callAction("WishList", "doControl", request);
        	break;
        	
        case "t":
        	this.request.put("mode", "PROGRESSLIST");
        	MainDispatcher.getInstance().callAction("Progress", "doControl", request);
        	break;
        	
        case "e":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}
