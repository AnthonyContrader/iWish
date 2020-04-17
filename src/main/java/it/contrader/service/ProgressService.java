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



//public void CalocloProgressi_soldi(ProdottoDTO prodottodto) {
//	double tempo;
//	prodottodto=new ProdottoDTO();
//	ProgressDTO progressdto=new ProgressDTO();
//	tempo= (prodottodto.getPrice()/progressdto.getClass());
//	progressdto.setTime(tempo);
	
//	
//}	

}
