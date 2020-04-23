import { Component, OnInit } from '@angular/core';
import { ProdottoService } from 'src/service/prodotto.service';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { UserDTO } from 'src/dto/userdto';
import { WishListDTO } from 'src/dto/wishlistdto';
import { CategoryDTO } from 'src/dto/categorydto';
import { WishListService } from 'src/service/wishlist.service';
import { CategoryService } from 'src/service/category.service';

@Component({
  selector: 'app-prodotto',
  templateUrl: './prodotto.component.html',
  styleUrls: ['./prodotto.component.css']
})
export class ProdottoComponent implements OnInit {

  prodotti: ProdottoDTO[];
  prodottotoinsert: ProdottoDTO = new ProdottoDTO();
  wishlist: WishListDTO;
  category: CategoryDTO;
  me: UserDTO;
  wishlists: WishListDTO[]=[];
  categories: CategoryDTO[]=[];

  constructor(private service: ProdottoService, private wishlistservice: WishListService, private categoryservice: CategoryService) { }

  ngOnInit() {
    this.getProdotto();
    this.me = JSON.parse(localStorage.getItem('currentUser'));
    this.getwishlists();
    this.getcategories();
  }

  getProdotto() {
    this.service.getAll().subscribe(prodotti => this.prodotti = prodotti);
  }

  getwishlists() {
    this.wishlistservice.getAll().subscribe(wish_lists => 
      {
        for (let w of wish_lists){
          if (w.proprietario.username===this.me.username)
          {this.wishlists.push(w);}
        }
      }
    );
    
  }

  getcategories() {
    this.categoryservice.getAll().subscribe(categories => 
      {
        for (let c of categories){
          if (c.proprietario_c.username===this.me.username)
          {this.categories.push(c);}
        }
      }
    );
    
  }

  delete(prodotto: ProdottoDTO) {
    this.service.delete(prodotto.id).subscribe(() => this.getProdotto());
  }

  update(prodotto: ProdottoDTO) {
    this.service.update(prodotto).subscribe(() => this.getProdotto());
  }

  insert(prodotto: ProdottoDTO, wishlist_id: number, category_id: number) {
    prodotto.proprietario=this.me;
    this.service.insert(prodotto).subscribe(() => this.getProdotto());
    
  }

  clear() {
    this.prodottotoinsert = new ProdottoDTO();
  }
}
