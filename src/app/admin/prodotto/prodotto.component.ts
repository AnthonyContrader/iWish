import { Component, OnInit } from '@angular/core';
import { ProdottoService } from 'src/service/prodotto.service';
import { ProdottoDTO } from 'src/dto/prodottodto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-prodotto',
  templateUrl: './prodotto.component.html',
  styleUrls: ['./prodotto.component.css']
})
export class ProdottoComponent implements OnInit {

  prodotto: ProdottoDTO[];
  prodottotoinsert: ProdottoDTO = new ProdottoDTO();
  proprietario: UserDTO;
  constructor(private service: ProdottoService) { }

  ngOnInit() {
    this.getProdotto();
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
  }

  getProdotto() {
    this.service.getAll().subscribe(prodotto => this.prodotto = prodotto);
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
