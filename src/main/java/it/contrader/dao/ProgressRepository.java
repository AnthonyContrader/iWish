package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;// convertita in repository posso utilizzare le crud
import org.springframework.stereotype.Repository;// rendo la mia entità una repository

import it.contrader.model.Progress;// importo il model


@Repository  // rendo la classe una repository
@Transactional // posso utilizzare hibernate utilizzando direttamente il model e non sql 

public interface ProgressRepository extends CrudRepository<Progress,Long> { // <entity ,primarykey> nel nostro caso id long

	Progress findByCashExpectationAndTime( float cash,double expectation,double time); // uso il model e non le query
}
