import { ElementRef } from '@angular/core';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-aluno',
  templateUrl: './list-aluno.component.html',
  styleUrls: ['./list-aluno.component.css']
})
export class ListAlunoComponent implements OnInit {

  constructor(
    private elemento: ElementRef
  ) { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
      this.elemento.nativeElement.ownerDocument.body.style.background = 'url(../../../../../assets/WhatsApp Image 2021-08-10 at 17.00.24.jpeg)';
  }

}
