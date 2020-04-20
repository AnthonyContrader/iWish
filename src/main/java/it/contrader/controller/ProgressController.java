package it.contrader.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.ProgressDTO;
import it.contrader.service.ProgressService;



@RestController
@RequestMapping("/progress")
@CrossOrigin(origins="://localhost:4200")

public class ProgressController extends AbstractController<ProgressDTO>{

	@Autowired
	private ProgressService progressservice;

}
