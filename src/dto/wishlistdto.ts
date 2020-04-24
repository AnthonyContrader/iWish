import { UserDTO } from './userdto';

export class WishListDTO{
    id: number;

    name: string;

    description: string;

    proprietario: UserDTO;

    constructor(id?: number, name?: string){
        this.id = id;
        this.name = name;
    }
   
    

}