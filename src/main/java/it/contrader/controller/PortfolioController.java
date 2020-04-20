package it.contrader.controller;



import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PortfolioDTO;



/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * 
 * @param<PortfolioDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController extends AbstractController<PortfolioDTO>{
	
	


	
	}
