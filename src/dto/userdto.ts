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
   login?: string;
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

   constructor(login?: string, firstName?: string, lastName?: string, email?:string, password?:string,authorities?:any, createdDate?: Date, lastModifiedDate?: Date, activated?: boolean){
     this.login = login;
     this.firstName = firstName;
     this.lastName = lastName;
     this.email = email;
     this.password = password;
     this.authorities = authorities;
     this.createdDate = createdDate;
     this.lastModifiedDate = lastModifiedDate;
     this.activated = activated;
   }
    

}

