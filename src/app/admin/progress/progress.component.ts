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
   expectation_value: number;
   soldi_value: number;
   giorni:number;
   differenza: any;

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
            if (p.proprietario_id === this.me.id)
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
      console.log(this.soldi_value);
    }
   
    changestatus(v:String){
      if (v==="visible")
      v="invisible";
      this.x=v;
    }

    aggiornamento (progress:ProgressDTO){

   
    this.expectation_value= this.arrotonda(progress.expectation);
    this.soldi_value=progress.cash;
    this.giorni= progress.time;
    this.differenza= new Date().getDay() - new Date(progress.data).getDay();
  
   if (this.expectation_value<100 && this.differenza>=0 )
   {
     this.expectation_value= this.expectation_value+ this.differenza *progress.expectation;
     this.soldi_value=this.soldi_value+ this.differenza *progress.cash;
     this.giorni= this.giorni-this.differenza;
     if (this.giorni<=0)
    this.giorni=0;
   }
   else 
   this.expectation_value=100;
  
    }

  }