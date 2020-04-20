package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.WishListDTO;
import it.contrader.model.WishList;

@Component
public class WishListConverter extends AbstractConverter<WishList, WishListDTO>{
	@Autowired
	private UserConverter userConverter;
	@Override
	public WishList toEntity(WishListDTO wishlistDTO) {
		WishList wishlist = null;
		
		
		
		if(wishlistDTO !=null) {
			wishlist = new WishList(wishlistDTO.getId(), wishlistDTO.getName(), wishlistDTO.getDescription(), userConverter.toEntity(wishlistDTO.getProprietario()));
		}
		return wishlist;
	}
	
	@Override
	public WishListDTO toDTO(WishList wishlist) {
		WishListDTO wishlistDTO = null;
		
		if(wishlist!=null) {
			wishlistDTO = new WishListDTO(wishlist.getId(), wishlist.getName(), wishlist.getDescription(), userConverter.toDTO(wishlist.getProprietario()));
		
		}
		return wishlistDTO;
	}

}
