import { UserDTO } from './userdto';

export class WishListDTO{
    id: number;

    name: string;

    description: string;

    proprietario_id: number;

    constructor(id?: number, name?: string){
        this.id = id;
        this.name = name;
    }
   
    

}