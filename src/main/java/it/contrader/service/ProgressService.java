package it.contrader.service;

import java.util.List;


import it.contrader.converter.ProgressConverter;
import it.contrader.dao.progressDAO;
import it.contrader.dto.ProgressDTO;

public class ProgressService {

	private progressDAO progressDAO; // creazione oggetto progress dao
	private ProgressConverter progressConverter;//creazione oggetto progress converter
	
	//????????????????????????????????????
	
	public ProgressService() {
		this.progressDAO=new progressDAO();
		this.progressConverter= new ProgressConverter();
	}

     public List<ProgressDTO> getAll(){
    	 //prende una lista di entità e le converte in DTO
    	 return progressConverter.toDTOList(progressDAO.getAll());
     }
     
     public ProgressDTO read (int id) {
    	 return progressConverter.toDTO(progressDAO.read(id));
     }
     
     public boolean insert (ProgressDTO dto) {
    	 // converte un DTO in entità e lo passsa al dao per l'inserimento
    	 return progressDAO.insert(progressConverter.toEntity(dto));
    	 
      }
     
      public boolean update (ProgressDTO dto) {
    	  //converte un progressDTO in entità e lo passa al progress DAo per la modifica
    	  return progressDAO.update(progressConverter.toEntity(dto));
    	  
      }

      public boolean delete( int id) {
    	  // questo metodo chiama direttamente il DAo
    	  return progressDAO.delete(id);
      }








}
