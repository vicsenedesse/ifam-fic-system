import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlunoComponent } from './aluno/aluno.component';
import { TurmaComponent } from './turma/turma.component';
import { ProfessorComponent } from './professor/professor.component';
import { CursoFicComponent } from './curso-fic/curso-fic.component';
import { UserComponent } from './user/user.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { FooterHomeComponent } from './footer-home/footer-home.component';
import { ListTurmaComponent } from './turma/list-turma/list-turma.component';


@NgModule({
  declarations: [
    AppComponent,

    AlunoComponent,
    TurmaComponent,
    //Importando as pastas do crud:
    ListTurmaComponent,
    ProfessorComponent,
    CursoFicComponent,
    UserComponent,


    ToolbarComponent,
    FooterComponent,
    HomeComponent,
    FooterHomeComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
