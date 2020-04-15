package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.WishListDTO;
import it.contrader.model.WishList;

@Component
public class WishListConverter extends AbstractConverter<WishList, WishListDTO>{
	
	@Override
	public WishList toEntity(WishListDTO wishlistDTO) {
		WishList wishlist = null;
		
		if(wishlistDTO !=null) {
			wishlist = new WishList(wishlistDTO.getId(), wishlistDTO.getName(), wishlistDTO.getDescription());
		}
		return wishlist;
	}
	
	@Override
	public WishListDTO toDTO(WishList wishlist) {
		WishListDTO wishlistDTO = null;
		if(wishlist!=null) {
			wishlistDTO = new WishListDTO(wishlist.getId(), wishlist.getName(), wishlist.getDescription());
		
		}
		return wishlistDTO;
	}

}
