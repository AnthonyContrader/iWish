import { Component, OnInit } from '@angular/core';
import { ProdottoService } from 'src/service/prodotto.service';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { UserDTO } from 'src/dto/userdto';
import { WishListDTO } from 'src/dto/wishlistdto';
import { CategoryDTO } from 'src/dto/categorydto';

@Component({
  selector: 'app-prodotto',
  templateUrl: './prodotto.component.html',
  styleUrls: ['./prodotto.component.css']
})
export class ProdottoComponent implements OnInit {

  prodotti: ProdottoDTO[];
  prodottotoinsert: ProdottoDTO = new ProdottoDTO();
  proprietario: UserDTO;
  wishlist: WishListDTO;
  category: CategoryDTO;
  
  constructor(private service: ProdottoService) { }

  ngOnInit() {
    this.getProdotto();
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
  }

  getProdotto() {
    this.service.getAll().subscribe(prodotti => this.prodotti = prodotti);
  }

  delete(prodotto: ProdottoDTO) {
    this.service.delete(prodotto.id).subscribe(() => this.getProdotto());
  }

  update(prodotto: ProdottoDTO) {
    this.service.update(prodotto).subscribe(() => this.getProdotto());
  }

  insert(prodotto: ProdottoDTO) {
    prodotto.proprietario=this.proprietario;
    this.service.insert(prodotto).subscribe(() => this.getProdotto());
  }

  clear() {
    this.prodottotoinsert = new ProdottoDTO();
  }
}
