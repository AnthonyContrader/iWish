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
  portfolio: PortfolioDTO[];
  portfoliotoinsert: PortfolioDTO = new PortfolioDTO();
  proprietario: UserDTO;
  constructor(private service: PortfolioService) { }


  ngOnInit() {
    this.getPortfolio();
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
  }

  getPortfolio() {
    this.service.getAll().subscribe(portfolio => this.portfolio = portfolio);
  }

  delete (portfolio: PortfolioDTO) {
    this.service.delete(portfolio.id).subscribe(() => this.getPortfolio());
  }

  update(portfolio: PortfolioDTO) {
    this.service.update(portfolio).subscribe(() => this.getPortfolio());
  }

  insert(portfolio: PortfolioDTO) {
  portfolio.proprietario = this.proprietario;
    this.service.insert(portfolio).subscribe(() => this.getPortfolio());
  }

  clear(){
    this.portfoliotoinsert = new PortfolioDTO();
  }
}

