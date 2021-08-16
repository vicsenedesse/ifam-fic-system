import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from 'src/app/model/professor.model';
import { ProfessorService } from 'src/app/service/professor.service';


import {FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-create-professor',
  templateUrl: './create-professor.component.html',
  styleUrls: ['./create-professor.component.css']
})
export class CreateProfessorComponent implements OnInit {

  user: Professor = new Professor();
  submitted = false;

  constructor(
    private professorService: ProfessorService,
    private router: Router

  ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
    this.professorService.create(this.user)
    .subscribe(data => console.log(data), error => console.log(error));
    this.user = new Professor();
    this.router.navigate(['/professor']);
  }

}
