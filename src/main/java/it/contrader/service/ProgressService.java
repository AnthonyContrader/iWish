package it.contrader.service;



import org.springframework.stereotype.Service;



import it.contrader.dto.ProgressDTO;
import it.contrader.dto.ProdottoDTO;

import it.contrader.model.Progress;


@Service
public class ProgressService extends AbstractService <Progress,ProgressDTO>{



public void CalcoloProgressi_soldi( ProgressDTO progressdto) {
	double tempo;
	
	
	ProdottoDTO prodottodto= progressdto.getProdotto();
	tempo=prodottodto.getPrice()/ progressdto.getCash();
	progressdto.setTime(tempo);
	progressdto.setExpectation(1*100/tempo);
}	

public void CalcoloProgressi_giorni(ProgressDTO progressdto) {
	double soldi;
	
	ProdottoDTO prodottodto= progressdto.getProdotto();
	soldi=prodottodto.getPrice()/progressdto.getTime() ;
	progressdto.setCash((float)soldi);
	progressdto.setExpectation((soldi*100)/prodottodto.getPrice());
}	

}
