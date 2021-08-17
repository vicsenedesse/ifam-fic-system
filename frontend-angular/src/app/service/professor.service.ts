import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import {Observable} from "rxjs/index";
import { Professor } from "../model/professor.model";
import { environment } from 'src/environments/environment';


@Injectable()
export class ProfessorService {

  constructor(
    private http: HttpClient) { }
    private baseUrl: string = 'http://localhost:3000/professor/';


    create(user: Professor): Observable<any> {
      return this.http.post<any>(this.baseUrl, user);
    }

    delete(id: any): Observable<any>{
        return this.http.delete<any>(`${this.baseUrl}/${id}`);
    }

    getUser() : Observable<any> {
        return this.http.get<any>(this.baseUrl);
    }
    
    // getById(id: any): Observable<any> {
    //   return this.http.get<any>(`${this.baseUrl}/${id}`);
    // }

    getById(id: number): Observable<any> {
      return this.http.get(this.baseUrl + id);
    }

    // update(id: number, user: Professor): Observable<any> {
    //    return this.http.put<any>(`${this.baseUrl}${id}`, user);
    // }

    update(id: number, user: Professor): Observable<any> {
      return this.http.put<any>(this.baseUrl + user.id, user);
    }

}
