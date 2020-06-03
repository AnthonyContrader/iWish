package com.it.contrader.repository;

import com.it.contrader.domain.WishList;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



/**
 * Spring Data  repository for the WishList entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findAllByProprietarioId(Long proprietarioId);
}
