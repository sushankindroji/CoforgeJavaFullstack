import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Directivesdemo19Component } from './directivesdemo19.component';

describe('Directivesdemo19Component', () => {
  let component: Directivesdemo19Component;
  let fixture: ComponentFixture<Directivesdemo19Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Directivesdemo19Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Directivesdemo19Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
