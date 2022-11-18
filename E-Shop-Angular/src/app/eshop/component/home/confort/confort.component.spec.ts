import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfortComponent } from './confort.component';

describe('ConfortComponent', () => {
  let component: ConfortComponent;
  let fixture: ComponentFixture<ConfortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConfortComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
