package it.contrader.converter; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

import it.contrader.dto.ProgressDTO;
import it.contrader.model.Progress;




@Component
public class ProgressConverter extends AbstractConverter<Progress,ProgressDTO> {
                                                                              

	@Autowired
	private ProdottoConverter prodottoconverter;
	
	@Override  
	public Progress toEntity(ProgressDTO progressDTO) { 
		Progress progress=null;
		if(progressDTO != null) {
			progress = new Progress(progressDTO.getId(),progressDTO.getCash(),progressDTO.getExpectation(),progressDTO.getTime(),prodottoconverter.toEntity(progressDTO.getProdotto()), progressDTO.getData());
			
		}
		return progress;
	}

	@Override
	public ProgressDTO toDTO(Progress progress) {
		
		ProgressDTO progressDTO=null;
		if(progress != null) {
			
			progressDTO= new ProgressDTO(progress.getId(),progress.getCash(),progress.getExpectation(),progress.getTime(),prodottoconverter.toDTO(progress.getProdotto()), progress.getData());
			
		}
	return progressDTO;
	}
	
}
