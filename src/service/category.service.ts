import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CategoryDTO } from 'src/dto/categorydto';

@Injectable({
  providedIn: 'root'
})
export class CategoryService extends AbstractService<CategoryDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'category';
   }
}
