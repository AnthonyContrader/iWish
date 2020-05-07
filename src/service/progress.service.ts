import { Injectable } from '@angular/core';
import {ProgressDTO} from 'src/dto/progressdto'
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { Observable } from 'rxjs';


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
 
Calcolo_inserisci_soldi(progressdto: ProgressDTO): Observable<any>{
  
 const prodottodto : ProdottoDTO = progressdto.prodotto;
 
 
 this.tempo=prodottodto.price/progressdto.cash;
const p: ProgressDTO=new ProgressDTO(0,progressdto.cash,(1*100/this.tempo),this.tempo,prodottodto,progressdto.data)
 
 return this.insert(p);
 
}
 Calcolo_inserisci_giorni(progressdto: ProgressDTO): Observable<any>{

const prodottodto: ProdottoDTO = progressdto.prodotto; 
this.soldi=prodottodto.price/progressdto.time;
const p : ProgressDTO= new ProgressDTO(0,this.soldi,(this.soldi*100/prodottodto.price),progressdto.time,prodottodto,progressdto.data)

return this.insert(p);
 }

}


	
