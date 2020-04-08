package it.contrader.service;

import it.contrader.converter.PortfolioConverter;
import it.contrader.dao.PortfolioDAO;
import it.contrader.dto.PortfolioDTO;
import it.contrader.model.Portfolio;

public class PortfolioService extends AbstractService<Portfolio, PortfolioDTO> {
	
	public PortfolioService(){
		this.dao = new PortfolioDAO();
		this.converter = new PortfolioConverter();
	}

}
