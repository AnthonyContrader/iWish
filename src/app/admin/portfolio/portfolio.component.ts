import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/service/portfolio.service';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { UserDTO } from 'src/dto/userdto';
import { Chart } from 'chart.js';






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
  saldi: number[]=[];
  entrate:number[]=[];
  uscite: number[]=[];
  date: Date[]=[];
  mychart1: Chart;
  mychart2: Chart;
  mychart3: Chart;
 
  constructor(private service: PortfolioService) { }
  

  ngOnInit() {
    this.proprietario = JSON.parse(localStorage.getItem('currentUser'));
    this.getPortfolio();
    
    console.log (this.saldoAttuale);
    
  }

  getPortfolio() {
    this.service.getAll().subscribe(portafogli => {
      this.portfolio=[] ;
      this.saldi=[];
      this.date=[];
      this.entrate=[];
      this.uscite=[];
      let id=0;
      this.saldoAttuale=0;
      for(let p of portafogli){ 
        if (p.proprietario.username===this.proprietario.username){
          this.portfolio.push(p);
          this.saldi.push(p.totalmoney);
          this.entrate.push(p.revenue);
          this.uscite.push(p.outputs);
          this.date.push(p.date);
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

  grafico(){

    this.mychart1 = new Chart("myChart1",
      {
        type: 'line',
        data: {
          labels:this.date.map(t => t.toLocaleString([], { month: '2-digit', day: '2-digit', year: '2-digit', hour: '2-digit', minute: '2-digit' })),
          

          datasets: [
            {
              data: this.saldi,
            }
          ]
        },
        options: {
        }
    
      });
    }
  /*this.mychart1 = new Chart("myChart1", {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
      
        labels: this.date,
        datasets: [{
            label: 'Andamento portafoglio',
            fill: 'toself',
            backgroundColor: 'blue',
            

            borderColor: 'rgb(000, 255, 000)',
            data: this.saldi
        }]
    },

    // Configuration options go here
    options: {}
});*/
  

  grafico1(){
    this.mychart2 = new Chart("myChart2", {
    // The type of chart we want to create
    type: 'bar',

    // The data for our dataset
    data: {
        labels: this.date,
        datasets: [{
            label: 'Andamento entrate',
            backgroundColor: "green",
            
        
           
            borderColor: 'rgb(000, 255, 000)',
            data: this.entrate
        }]
    },

    // Configuration options go here
    options: {}
});
  }

  grafico2(){
    
     this.mychart3 = new Chart("myChart3", {
    // The type of chart we want to create
    type: 'bar',

    // The data for our dataset
    data: {
        labels: this.date,
        datasets: [{
            label: 'Andamento uscite',
            backgroundColor: "green",
           
            borderColor: 'rgb(000, 255, 000)',
            data: this.uscite
        }]
    },

    // Configuration options go here
    options: {}
});
  }
 
  
}

