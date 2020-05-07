package com.it.contrader.service.impl;

import com.it.contrader.service.ProgressService;
import com.it.contrader.domain.Progress;
import com.it.contrader.repository.ProgressRepository;
import com.it.contrader.service.dto.ProgressDTO;
import com.it.contrader.service.mapper.ProgressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Progress.
 */
@Service
@Transactional
public class ProgressServiceImpl implements ProgressService {

    private final Logger log = LoggerFactory.getLogger(ProgressServiceImpl.class);

    private final ProgressRepository progressRepository;

    private final ProgressMapper progressMapper;

    public ProgressServiceImpl(ProgressRepository progressRepository, ProgressMapper progressMapper) {
        this.progressRepository = progressRepository;
        this.progressMapper = progressMapper;
    }

    /**
     * Save a progress.
     *
     * @param progressDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProgressDTO save(ProgressDTO progressDTO) {
        log.debug("Request to save Progress : {}", progressDTO);
        Progress progress = progressMapper.toEntity(progressDTO);
        progress = progressRepository.save(progress);
        return progressMapper.toDto(progress);
    }

    /**
     * Get all the progresses.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProgressDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Progresses");
        return progressRepository.findAll(pageable)
            .map(progressMapper::toDto);
    }


    /**
     * Get one progress by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProgressDTO> findOne(Long id) {
        log.debug("Request to get Progress : {}", id);
        return progressRepository.findById(id)
            .map(progressMapper::toDto);
    }

    /**
     * Delete the progress by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Progress : {}", id);
        progressRepository.deleteById(id);
    }
}
