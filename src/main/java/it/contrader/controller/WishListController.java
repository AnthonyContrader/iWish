package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.WishListDTO;
import it.contrader.service.WishListService;

@Controller
@RequestMapping("/wishlist")
public class WishListController {
	@Autowired 
	WishListService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/wishlist/wishlists";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "/wishlist/wishlists";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "wishlist/updatewishlist";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id,
			@RequestParam("name") String name, @RequestParam("description") String description) {
		WishListDTO dto = new WishListDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setDescription(description);
		service.update(dto);
		setAll(request);
		return "wishlist/wishlists";
		}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("description") String description) {
		WishListDTO dto = new WishListDTO();
		dto.setName(name);
		dto.setDescription(description);
		service.insert(dto);
		setAll(request);
		return "wishlist/wishlists";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "wishlist/readwishlist";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list",service.getAll());
	}
	
}
