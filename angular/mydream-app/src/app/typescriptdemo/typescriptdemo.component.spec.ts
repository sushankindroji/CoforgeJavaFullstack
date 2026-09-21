import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypescriptdemoComponent } from './typescriptdemo.component';

describe('TypescriptdemoComponent', () => {
  let component: TypescriptdemoComponent;
  let fixture: ComponentFixture<TypescriptdemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TypescriptdemoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypescriptdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
