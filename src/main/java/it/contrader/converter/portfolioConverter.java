package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.portfolioDTO;
import it.contrader.model.portfolio;

public class portfolioConverter {
	

	public portfolioDTO toDTO(portfolio Portfolio) {
		portfolioDTO PortfolioDTO = new portfolioDTO(Portfolio.getId(), Portfolio.getTotalmoney(), Portfolio.getRevenue(), Portfolio.getOutputs());
		return PortfolioDTO;

}
	public portfolio toEntity(portfolioDTO PortfolioDTO) {
		portfolio Portfolio = new portfolio(PortfolioDTO.getId(), PortfolioDTO.getTotalmoney(), PortfolioDTO.getRevenue(), PortfolioDTO.getOutputs());
		return Portfolio;
	}
	
	
	public List<portfolioDTO> toDTOList(List<portfolio> PortfolioList) {
		//Crea una lista vuota.
		
		List<portfolioDTO> PortfolioDTOList = new ArrayList<portfolioDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		
		for(portfolio Portfolio : PortfolioList) {
			
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			
			PortfolioDTOList.add(toDTO(Portfolio));
		}
		return PortfolioDTOList;
	}
}
	

