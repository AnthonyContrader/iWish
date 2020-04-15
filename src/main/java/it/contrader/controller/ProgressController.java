package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ProgressDTO;

import it.contrader.service.ProgressService;

@Controller
@RequestMapping("/progress")

public class ProgressController {

	
	   @Autowired
	   private ProgressService service;
	   
	   @GetMapping("/getall")
	   public String getAll(HttpServletRequest request) {
		   setAll(request);
		   return "/progress/progress";
		   
	   }
	   
	   @GetMapping("/delete")
		   public String delete(HttpServletRequest request,@RequestParam("id")Long id) {
		   service.delete(id);
		   setAll(request);
		   return "/progress/progress";
	   }
	   
	   @GetMapping("/preupdate")
	   public String preUpdate(HttpServletRequest request, @RequestParam("id")Long id) {
		   request.getSession().setAttribute("dto", service.read(id));
		   return "/progress/updateprogress";
		   
	   }
	   
	   
	   @GetMapping ("/update")
	   public String update(HttpServletRequest request,@RequestParam("id")Long id, @RequestParam("cash") float cash, @RequestParam("expectation") double expectation, @RequestParam("time") double time){
		   ProgressDTO dto = new ProgressDTO();
		   dto.setId(id);
		   dto.setCash(cash);
		   dto.setExpectation(expectation);
		   dto.setTime(time);
		   service.update(dto);
		   setAll(request);
		   return "/progress/progress";
		   
	   }
	   
	   @PostMapping("/insert")
	   public String insert (HttpServletRequest request, @RequestParam("cash") float cash,@RequestParam("expectation") double expectation, @RequestParam("time") double time) {
		   ProgressDTO dto = new ProgressDTO();
		   dto.setCash(cash);
		   dto.setExpectation(expectation);
		   dto.setTime(time);
		   service.insert(dto);
		   setAll(request);
		   return "/progress/progress";
	   }
	
	   @GetMapping("/read")
	   public String read(HttpServletRequest request, @RequestParam ("id") Long id) {
		   request.getSession().setAttribute("dto",service.read(id));
		   return "/progress/readprogress";
	   }
	   
	   private void setAll(HttpServletRequest request) {
		  request.getSession().setAttribute("list",service.getAll());
	   }
}
