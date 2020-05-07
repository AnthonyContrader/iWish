package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.ProductDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Product and its DTO ProductDTO.
 */
@Mapper(componentModel = "spring", uses = {WishListMapper.class, CategoryMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "wishlist_fk.id", target = "wishlist_fkId")
    @Mapping(source = "category_fk.id", target = "category_fkId")
    ProductDTO toDto(Product product);

    @Mapping(source = "wishlist_fkId", target = "wishlist_fk")
    @Mapping(source = "category_fkId", target = "category_fk")
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
