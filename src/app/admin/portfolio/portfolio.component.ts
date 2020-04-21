import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/service/portfolio.service';
import { PortfolioDTO } from 'src/dto/portfoliodto';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {
  portfolio: PortfolioDTO[];
  portfoliotoinsert: PortfolioDTO = new PortfolioDTO();
  constructor(private service: PortfolioService) { }


  ngOnInit() {
    this.getPortfolio();
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
    this.service.insert(portfolio).subscribe(() => this.getPortfolio());
  }

  clear(){
    this.portfoliotoinsert = new PortfolioDTO();
  }
}

