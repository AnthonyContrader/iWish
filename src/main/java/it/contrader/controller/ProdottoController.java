package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ProdottoDTO;
import it.contrader.service.ProdottoService;


@Controller
@RequestMapping("/prodotto")
public class ProdottoController {

	@Autowired
	private ProdottoService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/prodotto/prodotto";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/prodotto/prodotto";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/prodotto/updateprodotto";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") float price, @RequestParam("priority") int priority) {
		
		ProdottoDTO dto = new ProdottoDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		dto.setPrice(price);
		dto.setPriority(priority);
		service.update(dto);
		setAll(request);
		return "/prodotto/prodotto";
			
	}
	
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") float price, @RequestParam("priority") int priority) {
		
		ProdottoDTO dto = new ProdottoDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		dto.setPrice(price);
		dto.setPriority(priority);
		service.update(dto);
		setAll(request);
		return "/prodotto/prodotto";
		
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/prodotto/readprodotto";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
			
}
