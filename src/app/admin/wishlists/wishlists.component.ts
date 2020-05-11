import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { WishListDTO } from 'src/dto/wishlistdto';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { WishListService } from 'src/service/wishlist.service';
import { ProdottoService } from 'src/service/prodotto.service';
import {CategoryDTO} from 'src/dto/categorydto';

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
  cut_buffer_product: ProdottoDTO = null;
  product_idCut: number=0;

  constructor(private service: WishListService, private prodottoService: ProdottoService) { }

  ngOnInit() {
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getWishList();
  }



  getWishList() {
    this.service.getAll().subscribe(wishlists => {
      this.wishlists = [];
      for (let w of wishlists) {
        if (w.proprietario_id === this.proprietario.id) {
          this.wishlists.push(w);
        }
      }

    });
  }

  getProdotti(w: WishListDTO) {
    this.prodottoService.getAll().subscribe(products => {
      this.prodotti = [];
      for (let p of products) {
        if (p.proprietario_id=== this.proprietario.id) {
          if (p.wishlist_fkId != null) {
            if (p.wishlist_fkId === w.id) {
              this.prodotti.push(p);
            }
          }
        }
      }
    });
  }

  remove(p: ProdottoDTO, w: WishListDTO){
  
    p.wishlist_fkId = null;
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
    wishlist.proprietario_id = this.proprietario.id;
    this.service.insert(wishlist).subscribe(() => this.getWishList());
    this.clear();
  }

  clear() {
    this.wishlisttoinsert = new WishListDTO();
  }

  prepareCutBuffer(prodotto: ProdottoDTO){
    this.cut_buffer_product = prodotto;
    this.product_idCut = prodotto.id;

  }

  cancel(){

    this.cut_buffer_product = null;
    this.product_idCut=0;
  }

  paste( w: WishListDTO){
    this.cut_buffer_product.wishlist_fkId = w.id;
    this.prodottoService.update(this.cut_buffer_product).subscribe(()=>{
      this.getProdotti(w);
      this.cut_buffer_product =null;
      this.product_idCut=0;
    });

  }

}
