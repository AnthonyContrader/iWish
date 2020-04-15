package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Prodotto;

@Repository
@Transactional
public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {
	
	Prodotto findByProdottoname(String name, String description, float price, int priority);

}
