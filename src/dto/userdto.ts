import {Usertype} from './usertype';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

  /* id: number;

   username: string;

   password: string;

   usertype: Usertype; */
  
   id?: any;
   username?: string;
   firstName?: string;
   lastName?: string;
   email?: string;
   activated?: boolean;
   activationKey?: string;
   langKey?: string;
   authorities?: any[];
   createdBy?: string;
   createdDate?: Date;
   lastModifiedBy?: string;
   lastModifiedDate?: Date;
   password?: string;
    

}

