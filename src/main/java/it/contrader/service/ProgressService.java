package it.contrader.service;

import it.contrader.converter.ProgressConverter;
import it.contrader.dao.ProgressDAO;
import it.contrader.dto.ProgressDTO;
import it.contrader.model.Progress;

public class ProgressService extends AbstractService<Progress,ProgressDTO> {

public ProgressService() {
	this.dao=new ProgressDAO();
	this.converter=new ProgressConverter();
}
}
