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
    this.microservice_name= 'ProductManager';
    this.entity_name = 'progresses';
  }

 
Calcolo_inserisci_soldi(progressdto: ProgressDTO, prodottodto: ProdottoDTO): Observable<any>{
  

 
 
 this.tempo=prodottodto.price/progressdto.cash;
const p: ProgressDTO=new ProgressDTO(progressdto.cash,(1*100/this.tempo),this.tempo,prodottodto.id,progressdto.data)
 console.log(JSON.stringify(p));
 return this.insert(p);
 
}
 Calcolo_inserisci_giorni(progressdto: ProgressDTO, prodottodto: ProdottoDTO): Observable<any>{

this.soldi=prodottodto.price/progressdto.time;
const p : ProgressDTO= new ProgressDTO(this.soldi,(this.soldi*100/prodottodto.price),progressdto.time,prodottodto.id,progressdto.data)

return this.insert(p);
 }

}


	
