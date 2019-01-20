import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprofileFormComponent } from './userprofile-form.component';

describe('UserprofileFormComponent', () => {
  let component: UserprofileFormComponent;
  let fixture: ComponentFixture<UserprofileFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserprofileFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprofileFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
