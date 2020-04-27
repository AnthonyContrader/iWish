import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/service/portfolio.service';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { UserDTO } from 'src/dto/userdto';



@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {
  portfolio: PortfolioDTO[]=[];
  portfoliotoinsert: PortfolioDTO = new PortfolioDTO();
  proprietario: UserDTO;
  data : Date;
  saldoAttuale: number = 0;
  constructor(private service: PortfolioService) { }
  

  ngOnInit() {
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getPortfolio();
    
    console.log (this.saldoAttuale);
    
  }

  getPortfolio() {
    this.service.getAll().subscribe(portafogli => {
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
      
    });
  }
  

  delete (portfolio: PortfolioDTO) {
    this.service.delete(portfolio.id).subscribe(() => this.getPortfolio());
  }

  update(portfolio: PortfolioDTO) {
    this.service.update(portfolio).subscribe(() => this.getPortfolio());
  }

  insert(portfolio: PortfolioDTO) {
  portfolio.proprietario = this.proprietario;
  this.data = new Date();
  portfolio.date = this.data;
  this.service.operazione(portfolio, this.saldoAttuale).subscribe(() => this.getPortfolio());
  }

  clear(){
    this.portfoliotoinsert = new PortfolioDTO();
  }
 
  
}

