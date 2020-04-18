package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ProdottoDTO;
import it.contrader.dto.ProgressDTO;
import it.contrader.service.ProdottoService;
import it.contrader.service.ProgressService;

@Controller
@RequestMapping("/progress")

public class ProgressController {

	   @Autowired 
	   private ProdottoService prodottoservice; // usato per ottenere l'oggetto prodotto per la read per inserire l'id del prodotto
	   @Autowired
	   private ProgressService service;
	   
	   @GetMapping("/getall")
	   public String getAll(HttpServletRequest request) {
		   setAll(request);
		   return "/progress/progresschoice";
		   
	   }
	   
	   @GetMapping("/delete")
		   public String delete(HttpServletRequest request,@RequestParam("id")Long id) {
		   service.delete(id);
		   setAll(request);
		   return "/progress/progresschoice";
	   }
	   
	   @GetMapping("/preupdate")
	   public String preUpdate(HttpServletRequest request, @RequestParam("id")Long id) {
		   request.getSession().setAttribute("dto", service.read(id));
		   return "/progress/updateprogress";
		   
	   }
	   
	   
	   @PostMapping ("/update")
	   public String update(HttpServletRequest request,@RequestParam("id")Long id,  @RequestParam("time") double time){
		   ProgressDTO progressDTO= service.read(id);// service.read mi restituisce tutto il progresso che ha quell'id
		   ProdottoDTO prodottodto =progressDTO.getProdotto();// così ottendo il prodotto
		   ProgressDTO dto = new ProgressDTO();
		  
		   
		   dto.setId(id);
		  // dto.setCash(cash);
		   
		   dto.setTime(time);
		   dto.setProdotto(prodottodto);
		   service.CalcoloProgressi_giorni(dto);
		   service.update(dto);
		   
		   setAll(request);
		   return "/progress/progresschoice";
		   
	   }
	   
	   @PostMapping("/insertTime")
	   public String insertTime (HttpServletRequest request, @RequestParam("time") double time
			   ,@RequestParam ("prodotto_id") Long prodotto_id) {// tra le virgolette va il nome del name dell'input della view 
		   ProgressDTO dto = new ProgressDTO();
		   ProdottoDTO prodottodto= new ProdottoDTO();
		   prodottodto= prodottoservice.read(prodotto_id);
		  
		   dto.setTime(time);
		   dto.setProdotto(prodottodto);
		   service.CalcoloProgressi_giorni(dto);
		   service.insert(dto);
		   setAll(request);
		   return "/progress/progresschoice";
	   }
	   @PostMapping("/insertCash")
	   public String insertCash (HttpServletRequest request, @RequestParam("cash") float cash
			   ,@RequestParam ("prodotto_id") Long prodotto_id) {// tra le virgolette va il nome del name dell'input della view 
		   ProgressDTO dto = new ProgressDTO();
		   ProdottoDTO prodottodto= new ProdottoDTO();
		   prodottodto= prodottoservice.read(prodotto_id);
		   dto.setCash(cash);
		   dto.setProdotto(prodottodto);
		   service.CalcoloProgressi_soldi(dto);
		   service.insert(dto);
		   setAll(request);
		   return "/progress/progresschoice";
		   }
	   @GetMapping("/read")
	   public String read(HttpServletRequest request, @RequestParam ("id") Long id) {
		   request.getSession().setAttribute("dto",service.read(id));
		   return "/progress/readprogress";
	   }
	   
	   private void setAll(HttpServletRequest request) {
		  request.getSession().setAttribute("list",service.getAll());
	   }
	   @GetMapping("/progresschoice")
	   private void progressChoice(HttpServletRequest request) {
		   setAll(request);
	
		   
	   }
     


}
