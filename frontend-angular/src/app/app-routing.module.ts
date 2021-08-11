import { CursoFicComponent } from './curso-fic/curso-fic.component';
import { TurmaComponent } from './turma/turma.component';
import { ProfessorComponent } from './professor/professor.component';
import { AlunoComponent } from './aluno/aluno.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListTurmaComponent } from './turma/list-turma/list-turma.component';

const routes: Routes = [

  {path:'cursos', component:CursoFicComponent},
  {path:'turmas', component:ListTurmaComponent},
  {path:'professor', component:ProfessorComponent},
  {path:'aluno', component:AlunoComponent},
  {path:'home', component:HomeComponent},
  {path:'', component:HomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
