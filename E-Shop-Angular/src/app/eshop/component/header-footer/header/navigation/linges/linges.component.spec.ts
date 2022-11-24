import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LingesComponent } from './linges.component';

describe('LingesComponent', () => {
  let component: LingesComponent;
  let fixture: ComponentFixture<LingesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LingesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LingesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
