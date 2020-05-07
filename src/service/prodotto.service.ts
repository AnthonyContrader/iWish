import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdottoService extends AbstractService<ProdottoDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.microservice_name= 'ProductManager';
    this.entity_name = 'products';
  }

  
}
