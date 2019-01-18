import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalImageComponent } from './animal-image.component';

describe('AnimalImageComponent', () => {
  let component: AnimalImageComponent;
  let fixture: ComponentFixture<AnimalImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimalImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimalImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
