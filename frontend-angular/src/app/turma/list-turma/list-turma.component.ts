import { Router } from '@angular/router';
import { TurmaService } from './../../service/turma.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-turma',
  templateUrl: './list-turma.component.html',
  styleUrls: ['./list-turma.component.css']
})
export class ListTurmaComponent implements OnInit {

  aluno!: Observable<any>;
  constructor(private turmaService: TurmaService, private router :Router) { }

  ngOnInit() {
    this.aluno = this.turmaService.getTurma();
  }

  deleteTurma(id: number){
    this.turmaService.delete(id).subscribe(data =>{
      console.log(data);this.aluno = this.turmaService.getTurma();}, error => console.log(error));
  }

  updateTurma(turmaId: number){
    this.router.navigate(['/turmas/editar', turmaId])
  }

}
