package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import it.contrader.model.Portfolio;


@Repository
@Transactional
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {

	Portfolio findByPortfolioname(float totalmoney, float revenue, float outputs);

	}

