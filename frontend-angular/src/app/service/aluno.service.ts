import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import {Observable} from "rxjs/index";
import { Aluno } from "../model/aluno.model";
import { environment } from 'src/environments/environment';


@Injectable()
export class AlunoService {

  constructor(
    private http: HttpClient) { }
    private baseUrl: string = 'http://localhost:8080/api/';


    create(user: Aluno): Observable<any> {
      return this.http.post<any>(this.baseUrl + 'aluno', user);
    }

    delete(alunoId: any): Observable<any>{
        return this.http.delete<any>(`${this.baseUrl}${alunoId}`);
    }

    getAluno() : Observable<any> {
        return this.http.get<any>('http://localhost:8080/api/alunos');
    }

    getById(alunoId: number): Observable<any> {
      return this.http.get(this.baseUrl + alunoId);
    }

    update(alunoId: number, user: Aluno): Observable<any> {
      return this.http.put<any>(this.baseUrl + user.alunoID, user);
    }

}
