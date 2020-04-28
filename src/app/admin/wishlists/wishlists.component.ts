import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import {WishListDTO} from 'src/dto/wishlistdto';
import {WishListService} from 'src/service/wishlist.service';

@Component({
  selector: 'app-wishlists',
  templateUrl: './wishlists.component.html',
  styleUrls: ['./wishlists.component.css']
})
export class WishlistsComponent implements OnInit {
  wishlists: WishListDTO[];
  proprietario: UserDTO;
  wishlisttoinsert: WishListDTO = new WishListDTO();

  constructor(private service: WishListService ) { }

  ngOnInit() {
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getWishList();
  }

  

  getWishList(){
    this.service.getAll().subscribe(wishlists => this.wishlists = wishlists)
  }

  delete(wishlist: WishListDTO){
    this.service.delete(wishlist.id).subscribe(()=>this.getWishList());
  }
  
  update(wishlist: WishListDTO){
    this.service.update(wishlist).subscribe(()=>this.getWishList());
  }

  insert(wishlist: WishListDTO){
    wishlist.proprietario = this.proprietario;
    this.service.insert(wishlist).subscribe(()=>this.getWishList());
    this.clear();
  }

  clear(){
    this.wishlisttoinsert = new WishListDTO();
  }

}
