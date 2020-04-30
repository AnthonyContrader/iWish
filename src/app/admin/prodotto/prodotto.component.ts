import { Component, OnInit, wtfLeave } from '@angular/core';
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
  me: UserDTO;
  wishlist: WishListDTO;
  category: CategoryDTO;
  wishlists: WishListDTO[]=[];
  categories: CategoryDTO[]=[];
  class: string = "list-group-item";

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
       this.wishlists =[];
        for (let w of wish_lists){
          if (w.proprietario.username===this.me.username)
          {
            
            this.wishlists.push(new WishListDTO(w.id, w.name));
          
          }
        }
      }
    );
    
  }

  getcategories() {
    this.categoryservice.getAll().subscribe(categories => 
      {
        this.categories = [];
        for (let c of categories){
          if (c.proprietario_c.username===this.me.username)
          {this.categories.push(new CategoryDTO(c.id, c.name));}
        }
      }
    );
    
  }

  delete(prodotto: ProdottoDTO) {
    this.service.delete(prodotto.id).subscribe(() => this.getProdotto());
  }

  update(prodotto: ProdottoDTO) {
    this.wishlist = new WishListDTO(prodotto.wishlist.id, prodotto.wishlist.name);
    this.category = new CategoryDTO(prodotto.category.id, prodotto.category.name);
    prodotto.wishlist = this.wishlist;
    prodotto.category = this.category;
    console.log(JSON.stringify(prodotto));
    this.service.update(prodotto).subscribe(() => this.getProdotto());
  }

  insert(prodotto: ProdottoDTO) {

    prodotto.proprietario=this.me;
    console.log(JSON.stringify(prodotto));
    this.service.insert(prodotto).subscribe(() => this.getProdotto());
    this.clear();
    
  }

  clear() {
    this.prodottotoinsert = new ProdottoDTO();
  }

  compareFn(c1: CategoryDTO, c2: CategoryDTO): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
}

compareWishLists(w1: WishListDTO, w2: WishListDTO){
  return w1 && w2 ? w1.id === w2.id: w1===w2;
}

}

