package com.it.contrader.service.mapper;

import com.it.contrader.domain.*;
import com.it.contrader.service.dto.ProgressDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Progress and its DTO ProgressDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProgressMapper extends EntityMapper<ProgressDTO, Progress> {

    @Mapping(source = "prodotto_id.id", target = "prodotto_idId")
    ProgressDTO toDto(Progress progress);

    @Mapping(source = "prodotto_idId", target = "prodotto_id")
    Progress toEntity(ProgressDTO progressDTO);

    default Progress fromId(Long id) {
        if (id == null) {
            return null;
        }
        Progress progress = new Progress();
        progress.setId(id);
        return progress;
    }
}
