import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
  })
  export class PortfolioService extends AbstractService<PortfolioDTO>{
  
    /*totalmoney: number; */

    constructor(http: HttpClient) {
      super(http);
      this.type = 'portfolio';
    }
  
   /* Saldo_totalmoney(portfoliodto: PortfolioDTO)
{
  const totalmoney=(portfoliodto.revenue-portfoliodto.outputs);
  portfoliodto.totalmoney=this.totalmoney;
  portfoliodto.totalmoney=(portfoliodto.revenue-portfoliodto.outputs);
//
  } */
}