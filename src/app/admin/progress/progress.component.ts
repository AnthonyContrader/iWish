import { Component, OnInit } from '@angular/core';
import { ProgressService } from 'src/service/progress.service';
import { ProgressDTO } from 'src/dto/progressdto';
import { ProdottoDTO } from 'src/dto/prodottodto';
import{ProdottoService} from 'src/service/prodotto.service';
import { UserDTO } from 'src/dto/userdto';

import { PortfolioDTO } from 'src/dto/portfoliodto';



  
export class ProgressBarDeterminateExample {}


@Component({
  selector: 'app-progress',
  templateUrl: './progress.component.html',
  styleUrls: ['./progress.component.css']
  


})
export class ProgressComponent implements OnInit {
   prodottoId: number;
   progressi: ProgressDTO[];
   progressinsert: ProgressDTO = new ProgressDTO();
   prodotto: ProdottoDTO;
   me: UserDTO;
   prodotti: ProdottoDTO[]=[];
   table_visible: boolean  = false;
   y: number;
   progress:ProgressDTO = new ProgressDTO(0,0,0,0,new ProdottoDTO(0,"",0));
   x: String = "invisible";
   data: Date;
   portfolio_cash_attuale: PortfolioDTO;

  constructor(private service: ProgressService, private prodottoservice: ProdottoService) { }

  ngOnInit() {
    this.getProgress();
    this.me = JSON.parse(localStorage.getItem('currentUser'));
    this.getProdotti();
    this.data=new Date();
    
  }
 getProdotti(){
   this.prodottoservice.getAll().subscribe (products=>
       {
         for (let p of products){   
            if (p.proprietario.username===this.me.username)
            {
                 this.prodotti.push(new ProdottoDTO(p.id, p.name,p.price));
            }
          }

         
       });
 }


  getProgress(){
    this.service.getAll().subscribe (progressi=>this.progressi=progressi);
  }

  delete (progress: ProgressDTO){
  
    this.service.delete(progress.id).subscribe(()=>this.getProgress());
    this.progress = new ProgressDTO(0,0,0,0,new ProdottoDTO(0,"",0),this.data);
    this.x="invisible";
  }
  update(progress: ProgressDTO) {
    this.service.update(progress).subscribe(() => this.getProgress());
  }

 
  
  
  Calcolo_inserisci_giorni(progress:  ProgressDTO){
    progress.data= new Date();
    console.log(JSON.stringify(progress));
    this.service.Calcolo_inserisci_giorni(progress).subscribe(()=>this.getProgress());
    
  }
  Calcolo_inserisci_soldi(progress:  ProgressDTO){
    progress.data= new Date();
    console.log(JSON.stringify(progress));
    this.service.Calcolo_inserisci_soldi(progress).subscribe(()=>this.getProgress());
    
  }
  
 

  clear(){
    this.progressinsert= new ProgressDTO();
  }
   nascondi(){
    if (this.table_visible===true) 
    this.table_visible=false;
    else 
    this.table_visible=true;
     
   }
   arrotonda(x: number): number{
    let y: number; 
    y=Math.round(x);
     return y;



    }
    show(progress: ProgressDTO){
     
      this.progress=progress;
       this.aggiornamento(progress);
      this.x="visible";
    }
   
    changestatus(v:String){
      if (v==="visible")
      v="invisible";
      this.x=v;
    }

    aggiornamento (progress:ProgressDTO){

   
   let expectation_value: number=progress.expectation;
   let soldi_value: number=progress.cash;
   let giorni: number= progress.time;
 

   let differenza= new Date().getDay() - new Date(progress.data).getDay();
    
   console.log(differenza);
    }

  }