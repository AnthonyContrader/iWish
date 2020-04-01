package it.contrader.service;

import java.util.List;


import it.contrader.converter.ProdottoConverter;
import it.contrader.dao.prodottoDAO;
import it.contrader.dto.ProdottoDTO;

public class ProdottoService {

	private prodottoDAO prodottoDAO;
	private ProdottoConverter prodottoConverter;
	
	public ProdottoService() {
		this.prodottoDAO = new prodottoDAO();
		this.prodottoConverter = new ProdottoConverter();
	}
	
	public List<ProdottoDTO> getAll() {
		return prodottoConverter.toDTOList(prodottoDAO.getAll());
	}
	
	public ProdottoDTO read(int id) {
		return prodottoConverter.toDTO(prodottoDAO.read(id));
	}
		
	public boolean insert(ProdottoDTO dto) {
		return prodottoDAO.insert(prodottoConverter.toEntity(dto));
	}	
	
	public boolean update(ProdottoDTO dto) {
		return prodottoDAO.update(prodottoConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		return prodottoDAO.delete(id);
	}
	
}
