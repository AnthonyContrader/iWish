import  { ProdottoDTO } from './prodottodto'



export class ProgressDTO{

    id: number;

    cash: number;

    expectation: number;

    time: number;

    prodotto_idId: number;
    
    data : Date;

    prodotto: ProdottoDTO;

    constructor(cash?:number,expectation?:number,time?:number,prodotto_idId?:number, data?:Date, prodotto?: ProdottoDTO){

this.time=time;
this.expectation=expectation;
this.cash=cash;
this.prodotto_idId=prodotto_idId;
this.data=data;
this.prodotto = prodotto;

    }

}