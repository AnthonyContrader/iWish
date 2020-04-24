import  { ProdottoDTO } from './prodottodto'



export class ProgressDTO{

    id: number;

    cash: number;

    expectation: number;

    time: number;

    prodotto: ProdottoDTO;

    constructor(id?:number,cash?:number,expectation?:number,time?:number,prodotto?:ProdottoDTO){
this.id=id;
this.time=time;
this.expectation=expectation;
this.cash=cash;
this.prodotto=prodotto;

    }

}