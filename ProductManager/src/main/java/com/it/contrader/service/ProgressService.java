package com.it.contrader.service;

import com.it.contrader.service.dto.ProgressDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Progress.
 */
public interface ProgressService {

    /**
     * Save a progress.
     *
     * @param progressDTO the entity to save
     * @return the persisted entity
     */
    ProgressDTO save(ProgressDTO progressDTO);

    /**
     * Get all the progresses.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ProgressDTO> findAll(Pageable pageable);


    /**
     * Get the "id" progress.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProgressDTO> findOne(Long id);

    /**
     * Delete the "id" progress.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
