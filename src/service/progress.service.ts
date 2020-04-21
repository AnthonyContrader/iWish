import { Injectable } from '@angular/core';
import {ProgressDTO} from 'src/dto/progressdto'
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProgressService extends AbstractService<ProgressDTO>{

 
  
  constructor(http: HttpClient) {
    super(http);
    this.type = 'progress';
  }
  }

