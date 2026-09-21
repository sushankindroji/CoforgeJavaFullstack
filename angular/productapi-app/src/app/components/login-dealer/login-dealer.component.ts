import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-login-dealer',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login-dealer.component.html',
  styleUrl: './login-dealer.component.css'
})
export class LoginDealerComponent {

  loginData = {
    email: '',
    password: ''
  };

  errorMessage = '';
  successMessage = '';

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  onSubmit(): void {

    this.errorMessage = '';
    this.successMessage = '';

    if (!this.loginData.email || !this.loginData.password) {
      this.errorMessage = 'Please enter Email and Password.';
      return;
    }

    this.authService.login(this.loginData).subscribe({

      next: (response: boolean) => {

        if (response) {

          // Store session
          this.authService.setSession(
            'some-auth-token',
            this.loginData.email
          );

          this.successMessage = 'Login Successful. Redirecting...';

          setTimeout(() => {
            this.router.navigate(['/']);
          }, 2000);

        } else {

          this.errorMessage = 'Invalid Email or Password.';
        }

      },

      error: (error) => {

        console.error(error);

        this.errorMessage = error.message || 'Login Failed.';
      }

    });

  }

}