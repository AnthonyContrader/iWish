import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { WishListDTO } from 'src/dto/wishlistdto';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { WishListService } from 'src/service/wishlist.service';
import { ProdottoService } from 'src/service/prodotto.service';

@Component({
  selector: 'app-wishlists',
  templateUrl: './wishlists.component.html',
  styleUrls: ['./wishlists.component.css']
})
export class WishlistsComponent implements OnInit {
  wishlists: WishListDTO[];
  prodotti: ProdottoDTO[];
  prodotto: ProdottoDTO;
  proprietario: UserDTO;
  wishlisttoinsert: WishListDTO = new WishListDTO();


  constructor(private service: WishListService, private prodottoService: ProdottoService) { }

  ngOnInit() {
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getWishList();
  }



  getWishList() {
    this.service.getAll().subscribe(wishlists => {
      this.wishlists = [];
      for (let w of wishlists) {
        if (w.proprietario.username === this.proprietario.username) {
          this.wishlists.push(w);
        }
      }

    });
  }

  getProdotti(w: WishListDTO) {
    this.prodottoService.getAll().subscribe(products => {
      this.prodotti = [];
      for (let p of products) {
        if (p.proprietario.username === this.proprietario.username) {
          if (p.wishlist != null) {
            if (p.wishlist.id === w.id) {
              this.prodotti.push(p);
            }
          }
        }
      }
    });
  }

  remove(p: ProdottoDTO, w: WishListDTO){
    p.wishlist = null;
    this.prodotto = new ProdottoDTO();
    this.prodotto = p;
    
    this.prodottoService.update(p).subscribe(()=>{
      this.getProdotti(w);
    });
    
  }

  delete(wishlist: WishListDTO) {
    this.service.delete(wishlist.id).subscribe(() => this.getWishList());
  }

  update(wishlist: WishListDTO) {
    this.service.update(wishlist).subscribe(() => this.getWishList());
  }

  insert(wishlist: WishListDTO) {
    wishlist.proprietario = this.proprietario;
    this.service.insert(wishlist).subscribe(() => this.getWishList());
    this.clear();
  }

  clear() {
    this.wishlisttoinsert = new WishListDTO();
  }

}
