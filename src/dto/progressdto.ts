import  { ProdottoDTO } from './prodottodto'



export class ProgressDTO{

    id: number;

    cash: number;

    expectation: number;

    time: number;

    prodotto: ProdottoDTO;
    
    data : Date;

    constructor(id?:number,cash?:number,expectation?:number,time?:number,prodotto?:ProdottoDTO, data?:Date){
this.id=id;
this.time=time;
this.expectation=expectation;
this.cash=cash;
this.prodotto=prodotto;
this.data=data;

    }

}