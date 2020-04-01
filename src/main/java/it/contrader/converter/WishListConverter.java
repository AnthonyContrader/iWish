package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.model.WishList;
import it.contrader.dto.WishListDTO;

public class WishListConverter {
	
	public WishListDTO toDTO(WishList wishlist)
	{
		WishListDTO wishlistDTO = new WishListDTO(wishlist.getId(),wishlist.getName(), wishlist.getDescription());
		return wishlistDTO;
	}
	
	
	public WishList toEntity(WishListDTO wishlistDTO) 
	{
		WishList wishlist = new WishList(wishlistDTO.getId(), wishlistDTO.getName(), wishlistDTO.getDescription());
		return wishlist;
	}
	
	
	
	public List<WishListDTO> toDTOList(List<WishList> wishlists)
	{
		List<WishListDTO> wishlistDTOList = new ArrayList<WishListDTO>();
		
		for(WishList wishlist : wishlists) {
			wishlistDTOList.add(toDTO(wishlist));
		}
		return wishlistDTOList;
	}

}
