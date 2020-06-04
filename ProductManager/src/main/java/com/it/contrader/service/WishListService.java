package com.it.contrader.service;

import com.it.contrader.service.dto.WishListDTO;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing WishList.
 */
public interface WishListService {

    /**
     * Save a wishList.
     *
     * @param wishListDTO the entity to save
     * @return the persisted entity
     */
    WishListDTO save(WishListDTO wishListDTO);

    /**
     * Get all the wishLists.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<WishListDTO> findAll(Pageable pageable);


    /**
     * Get the "id" wishList.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<WishListDTO> findOne(Long id);

    /**
     * Delete the "id" wishList.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    /**
     * Get list of wishLists by owner
     */
    public List<WishListDTO> findByProprietario(long id);
    
}
