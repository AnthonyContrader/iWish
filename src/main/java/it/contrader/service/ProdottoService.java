package it.contrader.service;

import it.contrader.converter.ProdottoConverter;
import it.contrader.dao.ProdottoDAO;
import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Prodotto;


public class ProdottoService extends AbstractService<Prodotto, ProdottoDTO> {
	
	public ProdottoService() {
		this.dao = new ProdottoDAO();
		this.converter = new ProdottoConverter();
	}

}
