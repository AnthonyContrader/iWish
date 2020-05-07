package com.it.contrader.repository;

import com.it.contrader.domain.Progress;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Progress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

}
