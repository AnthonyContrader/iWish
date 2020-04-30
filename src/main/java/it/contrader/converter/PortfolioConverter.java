package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.PortfolioDTO;
import it.contrader.model.Portfolio;

@Component
public class PortfolioConverter extends AbstractConverter<Portfolio, PortfolioDTO>  {
    @Autowired
    private UserConverter userConverter;
	
	@Override
	public Portfolio toEntity(PortfolioDTO portfolioDTO) {
		Portfolio portfolio = null;
		if (portfolioDTO != null) {
			portfolio = new Portfolio(portfolioDTO.getId(), portfolioDTO.getTotalmoney(), portfolioDTO.getRevenue(), portfolioDTO.getOutputs(), portfolioDTO.getDate(), userConverter.toEntity(portfolioDTO.getProprietario()));
		}
		return portfolio;
	}

	@Override
	public PortfolioDTO toDTO(Portfolio portfolio) {
		PortfolioDTO portfolioDTO = null;
		if (portfolio != null) {
			portfolioDTO = new PortfolioDTO(portfolio.getId(), portfolio.getTotalmoney(), portfolio.getRevenue(), portfolio.getOutputs(),portfolio.getDate(), userConverter.toDTO(portfolio.getProprietario()));

		}
		return portfolioDTO;
	}
}
