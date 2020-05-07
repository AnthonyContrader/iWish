import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { PortfolioService } from 'src/service/portfolio.service';
import {UserService} from 'src/service/user.service';

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css']
})


export class AdminLayoutComponent implements OnInit {
  user: UserDTO=new UserDTO();
  portfolio: PortfolioDTO[]=[];
  saldoAttuale: number = 1;
  ciao: String="15";
  proprietario: UserDTO;
  
  
  constructor(private portfolioservice: PortfolioService, private userservice: UserService ) { 
    
  }

  ngOnInit() {
  
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getPortfolio();
    console.log (this.saldoAttuale);
  }
  getPortfolio() {
    this.portfolioservice.getAll().subscribe(portafogli => {
      this.portfolio=[] ;
      
     
      let id=0;
      this.saldoAttuale=0;
      for(let p of portafogli){ 
        if (p.proprietario.username===this.proprietario.username){
          this.portfolio.push(p);
         
          if (p.id>id){ 
            id=p.id;
            this.saldoAttuale=p.totalmoney;
          }
        }
      }
   
    });}

}
 



