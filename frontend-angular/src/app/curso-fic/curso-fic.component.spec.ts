import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoFicComponent } from './curso-fic.component';

describe('CursoFicComponent', () => {
  let component: CursoFicComponent;
  let fixture: ComponentFixture<CursoFicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoFicComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CursoFicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
