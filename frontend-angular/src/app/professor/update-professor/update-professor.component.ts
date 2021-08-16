import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Professor } from 'src/app/model/professor.model';
import { ProfessorService } from 'src/app/service/professor.service';


import {FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-update-professor',
  templateUrl: './update-professor.component.html',
  styleUrls: ['./update-professor.component.css']
})
export class UpdateProfessorComponent implements OnInit {


  id!: number;
  user!: Professor;
//   apiResponse!:ApiResponse;

  constructor(
    private route: ActivatedRoute,
    private professorService: ProfessorService,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.user = new Professor();

    this.id = this.route.snapshot.params['id'];
    this.professorService.getById(this.id)
      .subscribe((data) => {
        console.log(data)
        this.user = data;
      }, (error: any) => console.log(error));
  }

  onSubmit() {
    this.professorService.update(this.id, this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new Professor();
    this.router.navigate(['/professor']);
  }

//   refresh(): void {
//     window.location.reload();
//   }


}
