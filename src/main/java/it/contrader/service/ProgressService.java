package it.contrader.service;

// questo serve per impostare autowired cioè creare un collegamento con il beans che sarebbero gli oggetti 
//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

// il service comunica con il controller tramite i dto e 
// con il database attraverso i model quindi importiamo 
// dto model converter e repository che sarebbe il dao per creare le crud

import it.contrader.dto.ProgressDTO;
//import it.contrader.converter.ProgressConverter;
//import it.contrader.dao.ProgressRepository;
import it.contrader.model.Progress;

// stiamo definendo che fa parte del service con questo tag
@Service
public class ProgressService extends AbstractService <Progress,ProgressDTO>{
	
	//sono i campi che useremo
	
//	@Autowired
//	private ProgressConverter converter;
//	@Autowired
//	private ProgressRepository repository;
//	
//	//costruttore 
//	
//	public ProgressDTO findByCashExpectationAndTime(float cash, double expectation, double time){
//		return converter.toDTO(repository.findByCashExpectationAndTime(cash, expectation, time));
//	} 

}
