import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPaymentsComponent } from './view-payments.component';

describe('ViewPaymentsComponent', () => {
  let component: ViewPaymentsComponent;
  let fixture: ComponentFixture<ViewPaymentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPaymentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPaymentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
