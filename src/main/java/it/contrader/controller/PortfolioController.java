package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PortfolioDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PortfolioService;


@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	@Autowired
	private PortfolioService service;


@GetMapping("/getall")
public String getAll(HttpServletRequest request) {
	setAll(request);
	return "/portfolio/portfolio";
}

@GetMapping("/delete")
public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
	service.delete(id);
	setAll(request);
	return "/portfolio/portfolio";
}

@GetMapping("/preupdate")
public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
	request.getSession().setAttribute("dto", service.read(id));
	return "/portfolio/updateportfolio";
}

@PostMapping("/update")
public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("totalmoney") float totalmoney,
		@RequestParam("revenue") float revenue,@RequestParam("outputs")float outputs) {

	PortfolioDTO dto = new PortfolioDTO();
	dto.setId(id);
	dto.setTotalmoney(totalmoney);
	dto.setRevenue(revenue);
	dto.setOutputs(outputs);
	dto.setProprietario((UserDTO)request.getSession().getAttribute("user"));
	service.update(dto);
	setAll(request);
	return "/portfolio/portfolio";

}

@PostMapping("/insert")
public String insert(HttpServletRequest request, @RequestParam("totalmoney") float totalmoney,
		@RequestParam("revenue") float revenue, @RequestParam("outputs") float outputs) {
	PortfolioDTO dto = new PortfolioDTO();
	dto.setTotalmoney(totalmoney);
	dto.setRevenue(revenue);
	dto.setOutputs(outputs);
	dto.setProprietario((UserDTO)request.getSession().getAttribute("user"));
	service.insert(dto);
	setAll(request);
	return "/portfolio/portfolio";
}

@GetMapping("/read")
public String read(HttpServletRequest request, @RequestParam("id") Long id) {
	request.getSession().setAttribute("dto", service.read(id));
	return "/portfolio/readportfolio";
}




private void setAll(HttpServletRequest request) {
	request.getSession().setAttribute("list", service.getAll());
}
}

