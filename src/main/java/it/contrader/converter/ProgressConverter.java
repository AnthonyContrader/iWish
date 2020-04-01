package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProgressDTO;
import it.contrader.model.Progress;

public class ProgressConverter {



// il promo passaggio c'è uun oggetto DTO e lo riempie con i dati progress
	

	public ProgressDTO toDTO(Progress progress) {
		ProgressDTO progressDTO= new ProgressDTO(progress.getId(),progress.getCash(), progress.getExpectation(),progress.getTime());
		return progressDTO;
	
	}


// crezione oggetto di tipo Progress e lo riempie con i campi di Progress DTO
	
	public Progress toEntity(ProgressDTO progressDTO) {
		Progress progress= new Progress(progressDTO.getId(), progressDTO.getTime(), progressDTO.getExpectation(),progressDTO.getCash());
		return progress;
	}

//metodo per convertire le liste di Progress
	
	public List<ProgressDTO> toDTOList(List<Progress> progressList){
	// 	crea una lista vuota
		List<ProgressDTO> progressDTOList= new ArrayList<ProgressDTO>();
		//	cicla la lista e li converte a uno a uno
		for (Progress progress : progressList) {
			//con il metodo toDTO converte ogni singolo elemento e lo aggiunge alla liste di DTO	
			progressDTOList.add(toDTO(progress));
		}
	return progressDTOList;
	}









}
