package it.contrader.converter;

import it.contrader.model.WishList;
import it.contrader.dto.WishListDTO;
import java.util.List;
import java.util.ArrayList;

public class WishListConverter implements Converter<WishList, WishListDTO> {
	
	@Override
	public WishListDTO toDTO(WishList wishlist) {
		WishListDTO wishlistDTO = new WishListDTO(wishlist.getId(), wishlist.getName(), wishlist.getDescription());
		return wishlistDTO;
	}
	
	@Override
	public WishList toEntity(WishListDTO wishlistDTO) {
		WishList wishlist = new WishList(wishlistDTO.getId(), wishlistDTO.getName(), wishlistDTO.getDescription());
		return wishlist;
	}
	
	@Override 
	public List<WishListDTO> toDTOList(List<WishList> wishlists){
		List<WishListDTO> wishlistDTOList = new ArrayList<WishListDTO>();
		for(WishList wishlist: wishlists) {
			wishlistDTOList.add(toDTO(wishlist));
		}
		return wishlistDTOList;
	}

}
