package it.contrader.converter; // prendiamo i metodi di conversione

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; // questa libreria serve per rendere componente questa classe

import it.contrader.dto.ProgressDTO;
import it.contrader.model.Progress;// queste due classi servono per creare le conversioni tra le due forme diverso del dato

@Component
public class ProgressConverter extends AbstractConverter<Progress,ProgressDTO> {// extends fa riferimento a una sotto classe di cui utilizziamo i metodi
                                                                              // abstract converter chiede come parametri uno di tipo model e uno di tipo dto

	@Autowired
	private ProdottoConverter prodottoconverter;
	
	@Override  
	public Progress toEntity(ProgressDTO progressDTO) { // conversione da dto a model
		Progress progress=null;
		if(progressDTO != null) {
			progress = new Progress(progressDTO.getId(),progressDTO.getCash(),progressDTO.getExpectation(),progressDTO.getTime(),prodottoconverter.toEntity(progressDTO.getProdotto()));
			
		}
		return progress;
	}

	@Override
	public ProgressDTO toDTO(Progress progress) {// converisone da model a dto
		
		ProgressDTO progressDTO=null;
		if(progress != null) {
			
			progressDTO= new ProgressDTO(progress.getId(),progress.getCash(),progress.getExpectation(),progress.getTime(),prodottoconverter.toDTO(progress.getProdotto()));
			
		}
	return progressDTO;
	}
	
}
