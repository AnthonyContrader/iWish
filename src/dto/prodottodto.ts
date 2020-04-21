import { UserDTO } from './userdto';

export class ProdottoDTO {

    id: number;

    nome: string;

    descrizione: string;
    
    prezzo: number;

    priorita: number;
    
    proprietario: UserDTO;
}