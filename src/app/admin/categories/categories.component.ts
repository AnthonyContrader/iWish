import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/service/category.service';
import { CategoryDTO } from 'src/dto/categorydto';
import { UserDTO } from 'src/dto/userdto';
import { ProdottoService } from 'src/service/prodotto.service';
import { ProdottoDTO } from 'src/dto/prodottodto';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  categories: CategoryDTO[] = [];
  proprietario_c: UserDTO;
  categorytoinsert: CategoryDTO = new CategoryDTO();
  table: boolean = false;
  apri: number = 0;
  prodotto: ProdottoDTO;
  prodotti: ProdottoDTO[]=[];
  

  constructor(private service: CategoryService, private prodottoservice: ProdottoService) { }
   
   
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
        this.clear();
      }

      clear(){
        this.categorytoinsert = new CategoryDTO();
      }

      nascondi(){
        if(this.table === true)
        this.table = false;
        else
        this.table = true;
      }
      open(category_id: number) {
        if (this.apri === category_id){
          this.apri = 0;
        } else {
        this.apri = category_id;
        }
        
       this.getprodotti(category_id);
      }
       getprodotti(category_id: number) {
      this.prodottoservice.getAll().subscribe(prodotti => 
        {
          this.prodotti = [];
          for (let p of prodotti){
            if(p.category !== null){
            if (p.category.id === category_id)
            {this.prodotti.push(p);}
          }
        }

        }
      );
      
    }
      
  }


