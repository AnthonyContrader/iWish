package it.contrader.service;

import java.util.List;


import it.contrader.converter.portfolioConverter;
import it.contrader.dao.portfolioDAO;
import it.contrader.dto.portfolioDTO;


public class portfolioService {
	
	private portfolioDAO PortfolioDAO;
	private portfolioConverter PortfolioConverter;
	
	//Istanzio DAO  e Converter specifici.
	public portfolioService(){
		this.PortfolioDAO = new portfolioDAO();
		this.PortfolioConverter = new portfolioConverter();
	}
	
	public List<portfolioDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return PortfolioConverter.toDTOList(PortfolioDAO.getAll());
	}
	
	public portfolioDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return PortfolioConverter.toDTO(PortfolioDAO.read(id));
	}
	
	public boolean insert(portfolioDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return PortfolioDAO.insert(PortfolioConverter.toEntity(dto));
	}
	
	public boolean update(portfolioDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return PortfolioDAO.update(PortfolioConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return PortfolioDAO.delete(id);
	}

}
	