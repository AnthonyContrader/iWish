package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.WishListDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity WishList and its DTO WishListDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WishListMapper extends EntityMapper<WishListDTO, WishList> {



    default WishList fromId(Long id) {
        if (id == null) {
            return null;
        }
        WishList wishList = new WishList();
        wishList.setId(id);
        return wishList;
    }
}
