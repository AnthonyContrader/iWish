import { UserDTO } from './userdto';

export class ProdottoDTO {

    id: number;

    name: string;

    description: string;
    
    price: number;

    priority: number;
    
    proprietario: UserDTO;
}