import { UserDTO } from './userdto';
import { WishListDTO } from './wishlistdto';
import { CategoryDTO } from './categorydto';


export class ProdottoDTO {

    id: number;

    name: string;

    description: string;
    
    price: number;

    priority: number;
    
    wishlist: WishListDTO;
    
    category: CategoryDTO;
    
    proprietario: UserDTO;

    constructor(id?: number, name?: string,price?:number){
        this.id = id;
        this.name = name;
        this.price=price;
    }
}