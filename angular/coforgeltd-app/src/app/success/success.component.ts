import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-success',
  imports: [CommonModule, RouterLink],
  templateUrl: './success.component.html',
  styleUrl: './success.component.css'
})
export class SuccessComponent {

  userName: string = '';
  currentDate: Date = new Date();

  constructor() {
    this.userName = history.state.userName || '';
  }
}