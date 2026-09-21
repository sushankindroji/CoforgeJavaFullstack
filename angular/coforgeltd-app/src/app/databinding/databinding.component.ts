import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-databinding',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './databinding.component.html',
  styleUrl: './databinding.component.css'
})
export class DatabindingComponent {

  companyName: string = "Coforge Technologies";
  trainer: string = "Ajax";
  course: string = "Angular Framework";

  imagePath: string = "https://angular.io/assets/images/logos/angular/angular.svg";

  isDisabled: boolean = true;

  count: number = 0;

  message: string = "";

  increment() {
    this.count++;
  }

  showMessage() {
    this.message = "Welcome to Angular Data Binding!";
  }

  clearMessage() {
    this.message = "";
  }

  // Returns today's date for interpolation
  displayDate(): string {
    return new Date().toLocaleDateString();
  }

  // Returns addition result for interpolation
  num1: number = 100;
  num2: number = 200;

  add(): number {
    return this.num1 + this.num2;
  }

  // Area of Circle
  area(r: number): number {
    return Math.PI * r * r;
  }

  // Two-way binding
  message1: string = "Welcome to Angular Data Binding!";

  // Style binding
  textColor: string = "blue";
  bgColor: string = "lightyellow";
  fontSize: number = 24;
  isBold: boolean = true;

}