import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {WishListDTO}  from 'src/dto/wishlistdto';
import { AbstractService } from './abstractservice';
@Injectable({
  providedIn: 'root'
})
export class WishListService extends AbstractService<WishListDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.microservice_name= 'ProductManager';
    this.entity_name = 'wish-lists';
   }

   
}
