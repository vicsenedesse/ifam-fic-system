import { AlunoService } from './../../service/aluno.service';
import { Router } from '@angular/router';
import { ElementRef } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-aluno',
  templateUrl: './list-aluno.component.html',
  styleUrls: ['./list-aluno.component.css']
})
export class ListAlunoComponent implements OnInit {

  aluno!: Observable<any>;
  constructor(private alunoService: AlunoService, private router: Router) { }

  ngOnInit() {
    this.aluno = this.alunoService.getAluno();
  }

  deleteAluno(id: number){
    this.alunoService.delete(id).subscribe(data =>{
      console.log(data);this.aluno = this.alunoService.getAluno();}, error => console.log(error));
  }

  updateAluno(alunoId: number){
    this.router.navigate(['/aluno/editar', alunoId])
  }

}
