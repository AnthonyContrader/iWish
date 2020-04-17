package it.contrader.service;



import org.springframework.stereotype.Service;

// il service comunica con il controller tramite i dto e 
// con il database attraverso i model quindi importiamo 
// dto model converter e repository che sarebbe il dao per creare le crud

import it.contrader.dto.ProgressDTO;
import it.contrader.dto.ProdottoDTO;
//import it.contrader.converter.ProgressConverter;
//import it.contrader.dao.ProgressRepository;
import it.contrader.model.Progress;

// stiamo definendo che fa parte del service con questo tag
@Service
public class ProgressService extends AbstractService <Progress,ProgressDTO>{



public void CalcoloProgressi_soldi( ProgressDTO progressdto) {
	double tempo;
	
	
	ProdottoDTO prodottodto= progressdto.getProdotto();
	tempo=prodottodto.getPrice()/ progressdto.getCash();
	progressdto.setTime(tempo);
	progressdto.setExpectation(1*100/tempo);// ha mezzo senso da completare
}	

public void CalcoloProgressi_giorni(ProgressDTO progressdto) {
	double soldi;
	
	ProdottoDTO prodottodto= progressdto.getProdotto();
	soldi=prodottodto.getPrice()/progressdto.getTime() ;
	progressdto.setCash((float)soldi);
	progressdto.setExpectation((soldi*100)/prodottodto.getPrice());// idem con patate
}	

}
