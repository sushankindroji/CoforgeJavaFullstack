import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {

  title = 'product-hive-consumer';

  username: string = '';
  isUserLoggedIn: boolean = false;

  constructor(
  public authService: AuthenticationService,
  private router: Router
) {}

  ngOnInit(): void {
    // Subscribe to username changes
    this.authService.userName$.subscribe((email: string) => {
      this.username = email;
      this.isUserLoggedIn = this.authService.isLoggedIn();
    });
  }

  handleLogout(): void {

    this.authService.logout();

    this.router.navigate(['/logout']);

  }

}