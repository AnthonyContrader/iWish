import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PortfolioDTO } from '../dto/portfoliodto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { overrideComponentView } from '@angular/core/src/view';


@Injectable({
    providedIn: 'root'
  })
  export class PortfolioService extends AbstractService<PortfolioDTO>{
  
    
    constructor(http: HttpClient) {
      super(http);
      this.microservice_name= 'WalletManager';
      this.entity_name = 'wallets';
    }
  
   operazione(portfoliodto:PortfolioDTO, saldoAttuale: number):Observable<PortfolioDTO> {
     portfoliodto.totalmoney = saldoAttuale + (portfoliodto.revenue - portfoliodto.outputs);
     
     return this.insert(portfoliodto);
   }

   getAll(): Observable<PortfolioDTO[]> {
    return this.http.get<PortfolioDTO[]>(`http://localhost:8080/${this.microservice_name}/api/${this.entity_name}/byOwner/${this.proprietarioUsername}`, {headers: this.headerAuth});
}

}