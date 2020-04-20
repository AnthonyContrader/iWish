package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProdottoDTO;
import it.contrader.service.ProdottoService;



@RestController
@RequestMapping("/prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController extends AbstractController<ProdottoDTO> {

	@Autowired
	private ProdottoService prodottoservice;
	
}
