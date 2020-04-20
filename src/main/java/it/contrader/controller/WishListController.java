package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.WishListDTO;
import it.contrader.service.WishListService;


@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:4200")
public class WishListController extends AbstractController<WishListDTO> {
	@Autowired 
	private WishListService wishlistService;
}
