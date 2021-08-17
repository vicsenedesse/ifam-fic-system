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
import { SwiperImagesComponent } from './home/swiper/swiper-images.component';

import { ListTurmaComponent } from './turma/list-turma/list-turma.component';
import { ListProfessorComponent } from './professor/list-professor/list-professor.component';
import { SectionComponent } from './home/section/section.component';
import { InfoComponent } from './home/info/info.component';
import { ProfessorService } from './service/professor.service';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SortPipe } from 'src/pipe/pipe.component';
import { CreateProfessorComponent } from './professor/create-professor/create-professor.component';
import { UpdateProfessorComponent } from './professor/update-professor/update-professor.component';


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
    CreateProfessorComponent,
    UpdateProfessorComponent,


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
    SwiperImagesComponent,
    SectionComponent,
    InfoComponent,
    SortPipe



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    
  ],
  providers: 
  [
    ProfessorService,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
