package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProgressDTO;
import it.contrader.model.Progress;

public class ProgressConverter implements Converter<Progress, ProgressDTO> {

	@Override
	public ProgressDTO toDTO(Progress progress) {
		ProgressDTO progressDTO= new ProgressDTO(progress.getId(),progress.getCash(),progress.getExpectation(),progress.getTime(),progress.getForeing_proprietario(),progress.getForeing_prodotto());
	    return progressDTO;
	}
	@Override
	public Progress toEntity(ProgressDTO progressDTO) {
		Progress progress = new Progress(progressDTO.getId(), progressDTO.getCash(), progressDTO.getExpectation(), progressDTO.getTime(),progressDTO.getForeing_proprietario(),progressDTO.getForeing_prodotto());
		return progress;
	}

 @Override
 public List<ProgressDTO> toDTOList(List<Progress> progressList){
	 List<ProgressDTO> progressDTOList = new ArrayList<ProgressDTO>();
	 for(Progress progress : progressList) {
		 progressDTOList.add(toDTO(progress));
		 }
	 return progressDTOList;
	 }
}
