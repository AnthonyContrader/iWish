package it.contrader.service;
import it.contrader.converter.WishListConverter;
import it.contrader.dao.WishListDAO;
import it.contrader.dto.WishListDTO;
import it.contrader.model.WishList;

public class WishListService extends AbstractService<WishList, WishListDTO>{
	public WishListService() {
		this.dao = new WishListDAO();
		this.converter = new WishListConverter();
	}
}
