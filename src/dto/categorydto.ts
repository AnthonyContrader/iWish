import { UserDTO } from './userdto';


export class CategoryDTO {

id: number;

name: string;

description: string;

rating: number;

proprietario_id: number;

constructor(id?: number, name?: string){
    this.id = id;
    this.name = name;
}
  

}