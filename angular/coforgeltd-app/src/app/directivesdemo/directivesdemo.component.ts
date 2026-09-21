import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-directivesdemo',
  imports: [CommonModule],
  templateUrl: './directivesdemo.component.html',
  styleUrl: './directivesdemo.component.css'
})
export class DirectivesdemoComponent {

  showContent = true;
  selectedGrade = 'A';

  students = [
    { name: 'Ravi', marks: 85 },
    { name: 'Anita', marks: 45 },
    { name: 'John', marks: 72 }
  ];

  // Array
  skills: string[] = ['JavaScript', 'Angular', 'TypeScript','ReactJs'];
  
  toggleContent() {
    this.showContent = !this.showContent;
  }

  changeGrade(grade: string) {
    this.selectedGrade = grade;
  }

}
