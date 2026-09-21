import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipesdemoComponent } from './pipesdemo.component';

describe('PipesdemoComponent', () => {
  let component: PipesdemoComponent;
  let fixture: ComponentFixture<PipesdemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PipesdemoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PipesdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
