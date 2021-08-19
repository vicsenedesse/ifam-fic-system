import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Turma } from './../model/turma.model';
import {Observable} from "rxjs/index";
import { environment } from 'src/environments/environment';


@Injectable()
export class TurmaService {

  constructor(
    private http: HttpClient) { }
    private baseUrl: string = 'http://localhost:8080/api/';


    create(user: Turma): Observable<any> {
      return this.http.post<any>(this.baseUrl + 'Turma', user);
    }

    delete(turmaID: any): Observable<any>{
        return this.http.delete<any>(`${this.baseUrl}${turmaID}`);
    }

    getTurma() : Observable<any> {
        return this.http.get<any>('http://localhost:8080/api/turmas');
    }

    getById(turmaID: number): Observable<any> {
      return this.http.get(this.baseUrl + turmaID);
    }

    update(turmaID: number, user: Turma): Observable<any> {
      return this.http.put<any>(this.baseUrl + user.turmaID, user);
    }

}
