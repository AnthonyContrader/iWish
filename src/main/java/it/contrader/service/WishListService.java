package it.contrader.service;

import java.util.List;

import it.contrader.converter.WishListConverter;
import it.contrader.dao.WishListDAO;
import it.contrader.dto.WishListDTO;

public class WishListService {
	private WishListDAO wishlistDAO;
	private WishListConverter wishlistConverter;
	
	public WishListService()
	{
		this.wishlistDAO = new WishListDAO();
		this.wishlistConverter = new WishListConverter();
	}
	
	
	public List<WishListDTO> getAll()
	{
		return wishlistConverter.toDTOList(wishlistDAO.getAll());
	}
	
	public WishListDTO read(int id)
	{
		return wishlistConverter.toDTO(wishlistDAO.read(id));
	}
	
	public boolean insert(WishListDTO dto)
	{
		return wishlistDAO.insert(wishlistConverter.toEntity(dto));
	}
	
	public boolean update(WishListDTO dto)
	{
		return wishlistDAO.update(wishlistConverter.toEntity(dto));
	}
	
	public boolean delete(int id)
	{
		return wishlistDAO.delete(id);
	}
}
