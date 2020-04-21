import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgressiComponent } from './progressi.component';

describe('ProgressiComponent', () => {
  let component: ProgressiComponent;
  let fixture: ComponentFixture<ProgressiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgressiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgressiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
