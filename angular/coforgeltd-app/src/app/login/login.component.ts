import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  user = {
    email: '',
    password: ''
  };

  constructor(private router: Router) {}

  onSubmit(form: any) {

    if (form.invalid) {
      return;
    }

    console.log('Login Data:', this.user);

    if (
      this.user.email === 'admin@coforge.com' &&
      this.user.password === '123456'
    ) {
      alert('Login Successful');

    this.router.navigate(['/success'], {
      state: {
        userName: this.user.email
      }
    });

    } else {
      alert('Invalid Credentials');
    }
  }
}