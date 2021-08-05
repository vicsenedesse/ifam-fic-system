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
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    AlunoComponent,
    TurmaComponent,
    ProfessorComponent,
    CursoFicComponent,
    UserComponent,
    ToolbarComponent,
    MenuComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
