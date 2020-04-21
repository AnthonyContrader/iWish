import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
  })
  export class PortfolioService extends AbstractService<PortfolioDTO>{
  
    constructor(http: HttpClient) {
      super(http);
      this.type = 'portfolio';
    }
  
    
  }