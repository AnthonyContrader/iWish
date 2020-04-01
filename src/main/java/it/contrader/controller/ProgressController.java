package it.contrader.controller;
import java.util.List;

import it.contrader.dto.ProgressDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ProgressService;





public class ProgressController implements Controller {
	  // definisce il pacchetto di vista progress 
       private static String sub_package ="progress.";
       
       private ProgressService progressService;
        // costruisce un oggetto di tipo progress service per potere usare  i metodi
       
    	public ProgressController() {
    		this.progressService = new ProgressService();

   		}	   

     // il metodo controller estrae dalla request la mode che riceve dalle
    	//view le specifiche e può essere la richiesta di una 
    	//scelta da parte dell'utente "Getchoice") e la scelta dell'utente
    	//se la modalità corrisponde ad una CRUD il controller chiama i service
    	// altrimenti rimanda alla view della CRUD per richiedere i parametri 
    	
@Override
public void doControl(Request request){
		// estrae dalla request mode e choice
		String mode =(String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		// definisce i campi della classe(serviranno)
        int id;
        float cash;
        double expectation;
        double time;
        
        switch(mode) {
        
        case "READ":
        	id=Integer.parseInt(request.get("id").toString());
        	ProgressDTO progressDTO= progressService.read(id);
        	request.put("progress", progressDTO);
        	MainDispatcher.getInstance().callView(sub_package+ "ProgressRead", request);
        	
        //	estrae i parametri da inerire e chiama il service per inserire un progress con questi parametri
       
        
        case "INSERT":
			cash =Float.parseFloat( request.get("cash").toString());
			expectation =Double.parseDouble( request.get("expectation").toString());
			time =Double.parseDouble( request.get("time").toString());
			
			//costruisce l'oggetto user da inserire
			ProgressDTO progresstoinsert = new ProgressDTO( cash, expectation , time);
			//invoca il service
			progressService.insert(progresstoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ProgressInsert", request);
			break;
        
        
        
        
        
        // estrae l'id da cancellare e lo passa al service
        case "DELETE":
        	id=Integer.parseInt(request.get("id").toString());
        	// qui chiama il service 
        	progressService.delete(id);
        	request = new Request();
        	request.put("mode","mode");
        	MainDispatcher.getInstance().callView(sub_package +"ProgressDelete", request);
        	break;
        	
        	//Arriva qui dalla userUpdateview
        case "UPDATE":
        	id =Integer.parseInt(request.get("id").toString());
        	cash =Float.parseFloat(request.get("cash").toString());
        	expectation=Double.parseDouble( request.get("expectation").toString());
        	time= Double.parseDouble(request.get("time").toString());
        	ProgressDTO progresstoupdate =new ProgressDTO(cash,expectation,time);
        	progresstoupdate.setId(id);
        	progressService.update(progresstoupdate);
        	request =new Request();
        	request.put("mode","mode");
        	MainDispatcher.getInstance().callView(sub_package + "ProgressUpdate", request);
        	break;
        	
        	
        // invoca il service e invia alla userview il risultato da mostrare 
        	
        case "PROGRESSLIST":
        	List<ProgressDTO> progresslistDTO =progressService.getAll();
        	// impacchetta la request con i progress
        	request.put("progress",progresslistDTO);
        	MainDispatcher.getInstance().callView("Progress", request);
        	
        	// c'è uno switch sul comando e ti porta tramite il Dispatcher alla view scelta
        	
        case "GETCHOICE":
        	//toUppercase() mette in maiuscolo la scelta
        	switch(choice.toUpperCase()) {
        	
        	case "L":
        		MainDispatcher.getInstance().callView(sub_package + "ProgressRead", null);
        		break;
        	
        	case "I":
        		MainDispatcher.getInstance().callView(sub_package+"ProgressInsert", null);
        		break;
        	
        	case"M":
        		MainDispatcher.getInstance().callView(sub_package+"ProgressUpdate",null);
        		break;
        		
        	case "C":
        		MainDispatcher.getInstance().callView(sub_package +"ProgressDelete", null);
        		break;
        		
        	case "E":
        		MainDispatcher.getInstance().callView(sub_package+ "Login",null);
        		break;
        	
        	case "B":
        		MainDispatcher.getInstance().callView("HomeAdmin",null);
        		break;
        		
        	default:
        		MainDispatcher.getInstance().callView("Login", null);
        		break;
        		
        	
        	
        	
        	
        	}
        	
        	
        	
        
        
        
        }
        
        
        }





}
