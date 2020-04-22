import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/service/category.service';
import { CategoryDTO } from 'src/dto/categorydto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  categories: CategoryDTO[] = [];
  proprietario_c: UserDTO;
  categorytoinsert: CategoryDTO = new CategoryDTO();
  

  constructor(private service: CategoryService) { }
   
   
  ngOnInit() {
    this.proprietario_c = JSON.parse(localStorage.getItem('currentUser'));
    this.getCategory();
  }
     
    
  getCategory(){ 
       this.service.getAll().subscribe(categories => {
         this.categories = [];
         for (let c of categories){
           if(c.proprietario_c.username === this.proprietario_c.username) {
          this.categories.push(c); }
          }
        });
      }

      delete(category: CategoryDTO) {
        this.service.delete(category.id).subscribe(() => this.getCategory());
      }

      update(category: CategoryDTO) {
       this.service.update(category).subscribe(() => this.getCategory());
      }

      insert(category: CategoryDTO) {   
        category.proprietario_c = this.proprietario_c;        
        this.service.insert(category).subscribe(() => this.getCategory());
      }

      clear(){
        this.categorytoinsert = new CategoryDTO();
      }
    }
  
