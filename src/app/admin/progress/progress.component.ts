import { Component, OnInit } from '@angular/core';
import { ProgressService } from 'src/service/progress.service';
import { ProgressDTO } from 'src/dto/progressdto';
import { ProdottoDTO } from 'src/dto/prodottodto';
import{ProdottoService} from 'src/service/prodotto.service';
import { UserDTO } from 'src/dto/userdto';


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
  constructor(private service: ProgressService, private prodottoservice: ProdottoService) { }

  ngOnInit() {
    this.getProgress();
    this.me = JSON.parse(localStorage.getItem('currentUser'));
    this.getProdotti();
  }
 getProdotti(){
   this.prodottoservice.getAll().subscribe (products=>
       {
         for (let p of products){   
            if (p.proprietario.username===this.me.username)
            {
                 this.prodotti.push(p);
            }
          }

         
       });
 }

  getProgress(){
    this.service.getAll().subscribe (progressi=>this.progressi=progressi);
  }

  delete (progress: ProgressDTO){
  this.service.delete(progress.id).subscribe(()=>this.getProgress());
  
  }
  update(progress: ProgressDTO) {
    this.service.update(progress).subscribe(() => this.getProgress());
  }

  insert (progress: ProgressDTO, prodottoId: number){
    
    this.prodottoservice.read(prodottoId).subscribe(prodotto=>this.prodotto=prodotto);
    progress.prodotto=this.prodotto;
    console.log(prodottoId);
    this.service.insert(progress).subscribe(() => this.getProgress());
  }

  clear(){
    this.progressinsert= new ProgressDTO();
  }

}


