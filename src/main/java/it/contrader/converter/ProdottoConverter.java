package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Prodotto;

@Component
public class ProdottoConverter extends AbstractConverter<Prodotto, ProdottoDTO> {
	
	@Autowired
	WishListConverter wishlistconverter;
	
	@Autowired
	CategoryConverter categoryconverter;
	
	@Autowired
	UserConverter userconverter;
	
	@Override
	public Prodotto toEntity(ProdottoDTO prodottoDTO) {
		Prodotto prodotto = null;
		if (prodottoDTO != null) {
			prodotto = new Prodotto(prodottoDTO.getId(), prodottoDTO.getName(), prodottoDTO.getDescription(), prodottoDTO.getPrice(), prodottoDTO.getPriority(), prodottoDTO.getImage(),
					wishlistconverter.toEntity(prodottoDTO.getWishlist()), categoryconverter.toEntity(prodottoDTO.getCategory()), userconverter.toEntity(prodottoDTO.getProprietario()));
		}
		return prodotto;
	}
	
	@Override
	public ProdottoDTO toDTO(Prodotto prodotto) {
		ProdottoDTO prodottoDTO = null;
		if (prodotto != null) {
			prodottoDTO = new ProdottoDTO(prodotto.getId(), prodotto.getName(), prodotto.getDescription(), prodotto.getPrice(), prodotto.getPriority(),prodotto.getImage(),
					wishlistconverter.toDTO(prodotto.getWishlist()), categoryconverter.toDTO(prodotto.getCategory()), userconverter.toDTO(prodotto.getProprietario()));
		}
		return prodottoDTO;
	}
}
