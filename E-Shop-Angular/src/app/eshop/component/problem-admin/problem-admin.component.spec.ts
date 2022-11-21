import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemAdminComponent } from './problem-admin.component';

describe('ProblemAdminComponent', () => {
  let component: ProblemAdminComponent;
  let fixture: ComponentFixture<ProblemAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProblemAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProblemAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
