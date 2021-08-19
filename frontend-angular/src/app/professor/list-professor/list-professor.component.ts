import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Professor } from 'src/app/model/professor.model';
import { ProfessorService } from 'src/app/service/professor.service';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-list-professor',
  templateUrl: './list-professor.component.html',
  styleUrls: ['./list-professor.component.css']
})
export class ListProfessorComponent implements OnInit {

  users!: Observable<any>;

  filteredUser: Professor[] = [];
  _users: Professor[] = [];
  // @ts-ignore
  dtOptions: DataTables.Settings = {};
  // @ts-ignore
  @ViewChild('dtOptions', {static: true}) table;
  // users!: User[];
  private searchTerms = new Subject<any>();

  _filterBy!: string;
  searchText!: any;


  constructor(
    private ProfessorService: ProfessorService,
    private router: Router,

  )
  {}

  ngOnInit(): void {
    this.ProfessorService.getUser()
    .subscribe({
      next: users => {
        this._users = users;
        this.filteredUser = this._users;
      },
      error: err =>console.log('Error', err)
    });
  }

  update(professorId: number){
    this.router.navigate(['/atualizar/professor', professorId]);
  }

  delete(user: Professor){
    console.log(user)
    this.ProfessorService.delete(user.professorId).subscribe((resposta)=>{
      console.log("resposta ao deletar item", resposta)
      const indexDeletedUser = this._users.findIndex((item) => item.professorId == user.professorId)
      this._users.splice(indexDeletedUser, 1)
      this.filteredUser = this._users
      this._filterBy = ""

    })
  }

  set filter(any: any) {
    this._filterBy = any;
    if (any >= 0){
      this.filteredUser = this._users.filter((any: Professor) => 
                                                              any.professorId.toString().indexOf(this._filterBy) > -1 ||
                                                              any.matricula.toString().indexOf(this._filterBy) > -1
                                            );
    }
    else{
      this.filteredUser = this._users.filter((user: Professor) => 
                                                user.nome.toLocaleLowerCase().indexOf(this._filterBy.toLocaleLowerCase()) > -1
                                            );
    }
    
  }

  get filter() { 
    return this._filterBy;
  }


  

}
