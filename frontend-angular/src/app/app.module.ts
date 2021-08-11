import { ListAlunoComponent } from './aluno/list-aluno/list-aluno.component';
import { UpdateAlunoComponent } from './aluno/update-aluno/update-aluno.component';
import { CreateAlunoComponent } from './aluno/create-aluno/create-aluno.component';
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
import { SwiperModule } from 'swiper/angular';
import { SwiperImagesComponent } from './home/swiper/swiper-images.component';
import { ListTurmaComponent } from './turma/list-turma/list-turma.component';
import { ListProfessorComponent } from './professor/list-professor/list-professor.component';


@NgModule({
  declarations: [
    AppComponent,

    AlunoComponent,
    
    //TURMA
    TurmaComponent,
    ListTurmaComponent,

    //PROFESSOR
    ProfessorComponent,
    ListProfessorComponent,


    CursoFicComponent,
    UserComponent,

    /*Componentes Aluno*/
    CreateAlunoComponent,
    ListAlunoComponent,
    UpdateAlunoComponent,


    ToolbarComponent,
    FooterComponent,
    HomeComponent,
    FooterHomeComponent,
    SwiperImagesComponent



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SwiperModule
    // SwiperModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
