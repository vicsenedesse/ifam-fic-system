import { UpdateAlunoComponent } from './aluno/update-aluno/update-aluno.component';
import { CreateAlunoComponent } from './aluno/create-aluno/create-aluno.component';
import { CursoFicComponent } from './curso-fic/curso-fic.component';
import { TurmaComponent } from './turma/turma.component';
import { ProfessorComponent } from './professor/professor.component';
import { AlunoComponent } from './aluno/aluno.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListTurmaComponent } from './turma/list-turma/list-turma.component';
import { ListProfessorComponent } from './professor/list-professor/list-professor.component';
import { CreateProfessorComponent } from './professor/create-professor/create-professor.component';
import { UpdateProfessorComponent } from './professor/update-professor/update-professor.component';

const routes: Routes = [
/*----------------- ROTAS ALUNO ------------------*/
  {path:'aluno/cadastro', component:CreateAlunoComponent},
  {path:'aluno/editar/:id', component:UpdateAlunoComponent},

/*--------------- ROTAS PROFESSOR ----------------*/
  {path:'professor', component:ListProfessorComponent},
  {path:'adicionar/professor', component:CreateProfessorComponent},
  {path:'atualizar/professor/:id', component:UpdateProfessorComponent},


/*----------------- ROTAS TURMAS -----------------*/

/*----------------- ROTAS CURSOS -----------------*/

/*----------------- ROTAS GERAL ------------------*/
  {path:'cursos', component:CursoFicComponent},
  {path:'turmas', component:TurmaComponent},
  {path:'aluno', component:AlunoComponent},
  {path:'home', component:HomeComponent},
  {path:'', component:HomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
