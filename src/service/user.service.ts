import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from '../dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from '../dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService {

  path: string = 'http://localhost:8080/api';

  path_entity: string = 'http://localhost:8080/api/users';

  constructor(protected http: HttpClient) { }

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>(`${this.path}/authenticate`, loginDTO)
  }


  userLogged(username: string) {
    return this.http.get(`${this.path_entity}/` + username, {
      headers: {
        Authorization: localStorage.getItem('token')
      }
    });
  }



  getAll(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(`${this.path_entity}`);
  }

  get(id: number): Observable<UserDTO> {
    return this.http.get<UserDTO>(`${this.path_entity}/${id}`);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.path_entity}/${id}`);
  }


  update(dto: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>(`${this.path_entity}`, dto);
  }

  insert(user: UserDTO): Observable<any> {
    return this.http.post(`${this.path_entity}`, user);
  }

  //SIGNUP
  register(user: UserDTO):Observable<any>{
    return this.http.post(`${this.path}/register`, user);
  }



}
