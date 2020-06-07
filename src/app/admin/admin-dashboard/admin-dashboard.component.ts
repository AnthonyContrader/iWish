import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { PortfolioService } from 'src/service/portfolio.service';
import { ProdottoService } from 'src/service/prodotto.service';
import { ProdottoDTO } from 'src/dto/prodottodto';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  portfolio: PortfolioDTO[]=[];
  saldoAttuale: number = 0;
  proprietario: UserDTO;
  prodotti: ProdottoDTO[];
  me: UserDTO;
  
  

  constructor(private portfolioservice: PortfolioService, private prodottoservice: ProdottoService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getPortfolio();
    this.getProdotto();
  this.me = JSON.parse(localStorage.getItem('currentUser'));
  }
  getPortfolio() {
    this.portfolioservice.getAll().subscribe(portafogli => {
      this.portfolio=[] ;
      
     
      let id=0;
      this.saldoAttuale=0;
      for(let p of portafogli){ 
        
          this.portfolio.push(p);
         
          if (p.id>id){ 
            id=p.id;
            this.saldoAttuale=p.totalmoney;
          }
        
      }
   
    });}
    getProdotto() {
      this.prodottoservice.getAll().subscribe(prodotti => this.prodotti = prodotti);
    }



}

