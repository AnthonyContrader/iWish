package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;



import it.contrader.converter.PortfolioConverter;

import it.contrader.dao.PortfolioRepository;

import it.contrader.dto.PortfolioDTO;

import it.contrader.model.Portfolio;

public class PortfolioService extends AbstractService<Portfolio, PortfolioDTO> {

	
	@Autowired
	private PortfolioConverter converter;
	@Autowired
	private PortfolioRepository repository;

	public PortfolioDTO findByPortfolioname(float totalmoney, float revenue, Float outputs) {
		return converter.toDTO(repository.findByPortfolioname(totalmoney, revenue, outputs));
	}
}
