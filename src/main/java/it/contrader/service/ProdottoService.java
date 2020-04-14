package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ProdottoConverter;
import it.contrader.dao.ProdottoRepository;
import it.contrader.dto.ProdottoDTO;
import it.contrader.model.Prodotto;

@Service
public class ProdottoService extends AbstractService<Prodotto, ProdottoDTO> {
	
	@Autowired
	private ProdottoConverter converter;
	@Autowired
	private ProdottoRepository repository;
	
	public ProdottoDTO findByProdottoname(String name, String description, float price, int priority) {
		return converter.toDTO(repository.findByProdottoname(name, description, price, priority));
	}
}
