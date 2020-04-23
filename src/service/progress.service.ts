import { Injectable } from '@angular/core';
import {ProgressDTO} from 'src/dto/progressdto'
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { ProdottoDTO } from 'src/dto/prodottodto';


@Injectable({
  providedIn: 'root'
})
export class ProgressService extends AbstractService<ProgressDTO>{

 tempo: number;
 soldi: number;
  
  constructor(http: HttpClient) {
    super(http);
    this.type = 'progress';
  }
 
Calcolo_inserisci_soldi(progressdto: ProgressDTO){
  
 const prodottodto : ProdottoDTO = progressdto.prodotto;
 
 this.tempo=prodottodto.price/progressdto.cash;
 progressdto.time=this.tempo;
 progressdto.expectation=(1*100/this.tempo);

  
 
}
 Calcolo_inserisci_giorni(progressdto: ProgressDTO){

const prodottodto: ProdottoDTO = progressdto.prodotto; 
this.soldi=prodottodto.price/progressdto.time;
progressdto.cash=this.soldi;
progressdto.expectation=(progressdto.cash*100/prodottodto.price);

 }

}


	
