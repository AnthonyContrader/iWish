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
  categories: CategoryDTO[];
  proprietario_c: UserDTO;
  categorytoinsert: CategoryDTO = new CategoryDTO();
  

  constructor(private service: CategoryService) { }
   
   
  ngOnInit() {
    this.proprietario_c = JSON.parse(localStorage.getItem('currentUser'));
    this.getCategories();
  }

  

  getCategories(){
    this.service.getAll().subscribe(categories => this.categories = categories);
      }

      delete(category: CategoryDTO) {
        this.service.delete(category.id).subscribe(() => this.getCategories());
      }

      update(category: CategoryDTO) {
        this.service.update(category).subscribe(() => this.getCategories());
      }

      insert(category: CategoryDTO) {
        category.proprietario_c = this.proprietario_c;        
        this.service.insert(category).subscribe(() => this.getCategories());
      }

      clear(){
        this.categorytoinsert = new CategoryDTO();
      }
    }
  
