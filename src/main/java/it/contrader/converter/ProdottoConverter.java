package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Prodotto;

public class ProdottoConverter implements Converter<Prodotto, ProdottoDTO> {

	@Override
	public ProdottoDTO toDTO(Prodotto prodotto) {
		ProdottoDTO prodottoDTO = new ProdottoDTO(prodotto.getId(), prodotto.getName(), prodotto.getDescription(), prodotto.getPrice(), prodotto.getPriority(), prodotto.getProprietario(), prodotto.getId_categoria_fk(), prodotto.getId_whishlist_fk());
		return prodottoDTO;
	}
	
	@Override
	public Prodotto toEntity(ProdottoDTO prodottoDTO) {
		Prodotto prodotto = new Prodotto(prodottoDTO.getId(), prodottoDTO.getName(), prodottoDTO.getDescription(), prodottoDTO.getPrice(), prodottoDTO.getPriority(), prodottoDTO.getProprietario(), prodottoDTO.getId_categoria_fk(), prodottoDTO.getId_whishlist_fk());
		return prodotto;
	}
	
	@Override
	public List<ProdottoDTO> toDTOList(List<Prodotto> prodottoList) {
		List<ProdottoDTO> prodottoDTOList = new ArrayList<ProdottoDTO>();
		
		for(Prodotto prodotto : prodottoList) {
			prodottoDTOList.add(toDTO(prodotto));
		}
		return prodottoDTOList;
	}
	
}
