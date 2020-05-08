import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


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
}