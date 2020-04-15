package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PortfolioDTO;

import it.contrader.service.PortfolioService;


@Controller
@RequestMapping("/user")
public class PortfolioController {
	
	@Autowired
	private PortfolioService service;

	


	
		

	

@GetMapping("/getall")
public String getAll(HttpServletRequest request) {
	setAll(request);
	return "users";
}

@GetMapping("/delete")
public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
	service.delete(id);
	setAll(request);
	return "users";
}

@GetMapping("/preupdate")
public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
	request.getSession().setAttribute("dto", service.read(id));
	return "updateuser";
}

@PostMapping("/update")
public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("totalmoney") float totalmoney,
		@RequestParam("revenue") float revenue,@RequestParam("outputs")float outputs) {

	PortfolioDTO dto = new PortfolioDTO();
	dto.setId(id);
	dto.setTotalmoney(totalmoney);
	dto.setRevenue(revenue);
	dto.setOutputs(outputs);
	service.update(dto);
	setAll(request);
	return "users";

}

@PostMapping("/insert")
public String insert(HttpServletRequest request, @RequestParam("totalmoney") float totalmoney,
		@RequestParam("revenue") float revenue, @RequestParam("outputs") float outputs) {
	PortfolioDTO dto = new PortfolioDTO();
	dto.setTotalmoney(totalmoney);
	dto.setRevenue(revenue);
	dto.setOutputs(outputs);
	service.insert(dto);
	setAll(request);
	return "users";
}

@GetMapping("/read")
public String read(HttpServletRequest request, @RequestParam("id") Long id) {
	request.getSession().setAttribute("dto", service.read(id));
	return "readuser";
}

@GetMapping("/logout")
public String logout(HttpServletRequest request) {
	request.getSession().invalidate();
	return "index";
}

private void setAll(HttpServletRequest request) {
	request.getSession().setAttribute("list", service.getAll());
}
}

