import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectromenagerComponent } from './electromenager.component';

describe('ElectromenagerComponent', () => {
  let component: ElectromenagerComponent;
  let fixture: ComponentFixture<ElectromenagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElectromenagerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElectromenagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
