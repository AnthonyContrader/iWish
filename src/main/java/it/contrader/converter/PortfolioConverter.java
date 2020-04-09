package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PortfolioDTO;


import it.contrader.model.Portfolio;



public class PortfolioConverter implements Converter<Portfolio, PortfolioDTO> {
	
	@Override
	public PortfolioDTO toDTO(Portfolio portfolio) {
		PortfolioDTO portfolioDTO = new PortfolioDTO(portfolio.getId(), portfolio.getTotalmoney(), portfolio.getRevenue(), portfolio.getOutputs(), portfolio.getProprietario());
		return portfolioDTO;
	}
	
	@Override
	public Portfolio toEntity(PortfolioDTO portfolioDTO) {
		Portfolio portfolio = new Portfolio(portfolioDTO.getId(), portfolioDTO.getTotalmoney(), portfolioDTO.getRevenue(), portfolioDTO.getOutputs(), portfolioDTO.getProprietario());
		return portfolio;
	}
		
		
	@Override
	public List<PortfolioDTO> toDTOList(List<Portfolio> portfolioList) {
		//Crea una lista vuota.
		List<PortfolioDTO> portfolioDTOList = new ArrayList<PortfolioDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Portfolio portfolio : portfolioList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			portfolioDTOList.add(toDTO(portfolio));
		}
		return portfolioDTOList;

}
}
