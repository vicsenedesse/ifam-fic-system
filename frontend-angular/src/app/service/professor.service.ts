import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import {Observable} from "rxjs/index";
import { Professor } from "../model/professor.model";
import { environment } from 'src/environments/environment';


@Injectable()
export class ProfessorService {

  constructor(
    private http: HttpClient) { }
    private baseUrl: string = 'http://localhost:8080/api/professor/';


    create(user: Professor): Observable<any> {
      return this.http.post<any>(this.baseUrl + 'professor', user);
    }

    delete(professorId: any): Observable<any>{
        return this.http.delete<any>(`${this.baseUrl}${professorId}`);
    }

    getUser() : Observable<any> {
        return this.http.get<any>(this.baseUrl);
    }
    
    // getById(id: any): Observable<any> {
    //   return this.http.get<any>(`${this.baseUrl}/${id}`);
    // }

    getById(professorId: number): Observable<any> {
      return this.http.get(this.baseUrl + professorId);
    }

    // update(id: number, user: Professor): Observable<any> {
    //    return this.http.put<any>(`${this.baseUrl}${id}`, user);
    // }

    update(professorId: number, user: Professor): Observable<any> {
      return this.http.put<any>(this.baseUrl + user.professorId, user);
    }

}
