package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ProdottoDTO;

import it.contrader.model.Prodotto;

@Component
public class ProdottoConverter extends AbstractConverter<Prodotto, ProdottoDTO> {

	@Override
	public Prodotto toEntity(ProdottoDTO prodottoDTO) {
		Prodotto prodotto = null;
		if (prodottoDTO != null) {
			prodotto = new Prodotto(prodottoDTO.getId(), prodottoDTO.getName(), prodottoDTO.getDescription(), prodottoDTO.getPrice(), prodottoDTO.getPriority());
		}
		return prodotto;
	}
	
	@Override
	public ProdottoDTO toDTO(Prodotto prodotto) {
		ProdottoDTO prodottoDTO = null;
		if (prodotto != null) {
			prodottoDTO = new ProdottoDTO(prodotto.getId(), prodotto.getName(), prodotto.getDescription(), prodotto.getPrice(), prodotto.getPriority());
		}
		return prodottoDTO;
	}
}
