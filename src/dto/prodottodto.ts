import { UserDTO } from './userdto';
import { WishListDTO } from './wishlistdto';
import { CategoryDTO } from './categorydto';


export class ProdottoDTO {
    
    category_fkId: number;

    description: string;

    id: number;

    image: string;

    name: string;

    price: number;

    priority: number;

    proprietario_id: number;
    
    wishlist_fkId: number;
    
    constructor(id?: number, name?: string,price?:number){
        this.id = id;
        this.name = name;
        this.price=price;
    }
}