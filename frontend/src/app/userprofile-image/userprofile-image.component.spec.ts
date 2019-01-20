import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserprofileImageComponent } from './userprofile-image.component';

describe('UserprofileImageComponent', () => {
  let component: UserprofileImageComponent;
  let fixture: ComponentFixture<UserprofileImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserprofileImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserprofileImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
