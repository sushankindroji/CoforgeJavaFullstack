import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { TypescriptdemoComponent } from './typescriptdemo/typescriptdemo.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    TypescriptdemoComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'mydream-app';

  name: string = "Ajax";
  age: number = 25;
  isLoggedIn: boolean = true;

  hobbies: string[] = [
    'Reading',
    'Travelling',
    'Cooking',
    'Gaming',
    'Photography'
  ];
}