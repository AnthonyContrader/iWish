package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Progress;


@Repository  
@Transactional 

public interface ProgressRepository extends CrudRepository<Progress,Long> { 
	
}
