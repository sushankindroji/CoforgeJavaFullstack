import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // ===============================
  // REST API URLs
  // ===============================
  private readonly baseUrl = 'http://localhost:8088/producthive/api';

  // ===============================
  // Logged-in User Email
  // ===============================
  private userNameSubject = new BehaviorSubject<string>(
    localStorage.getItem('userEmail') || ''
  );

  userName$ = this.userNameSubject.asObservable();

  constructor(private http: HttpClient) {}

  // ===============================
  // Dealer Registration
  // ===============================
  registerDealer(data: any): Observable<string> {
    return this.http.post(
      `${this.baseUrl}/register`,
      data,
      { responseType: 'text' }
    ).pipe(
      catchError(this.handleError)
    );
  }

  // ===============================
  // Dealer Login
  // ===============================
  login(data: any): Observable<boolean> {
    return this.http.post<boolean>(
      `${this.baseUrl}/login`,
      data
    ).pipe(
      catchError(this.handleError)
    );
  }

  // ===============================
  // Dealer Information
  // ===============================
  getDealerInfo(): Observable<any[]> {
    return this.http.get<any[]>(
      `${this.baseUrl}/dealers`
    ).pipe(
      catchError(this.handleError)
    );
  }

  // ===============================
  // Session Management
  // ===============================
  setSession(token: string, email: string): void {
    localStorage.setItem('authToken', token);
    localStorage.setItem('userEmail', email);
    this.userNameSubject.next(email);
  }

  clearSession(): void {
    localStorage.removeItem('authToken');
    localStorage.removeItem('userEmail');
    this.userNameSubject.next('');
  }

  // Logout
  logout(): void {
    this.clearSession();
  }

  getUserEmail(): string {
    return localStorage.getItem('userEmail') || '';
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('authToken') !== null;
  }

  // ===============================
  // Error Handling
  // ===============================
  private handleError(error: HttpErrorResponse): Observable<never> {

    let errorMessage = 'Something went wrong. Please try again.';

    if (error.error instanceof ErrorEvent) {

      errorMessage = error.error.message;

    } else {

      switch (error.status) {

        case 0:
          errorMessage = 'Unable to connect to the server.';
          break;

        case 400:
          errorMessage = 'Bad Request.';
          break;

        case 401:
          errorMessage = 'Invalid Email or Password.';
          break;

        case 403:
          errorMessage = 'Access Denied.';
          break;

        case 404:
          errorMessage = 'Resource Not Found.';
          break;

        case 500:
          errorMessage = 'Internal Server Error.';
          break;

        default:
          errorMessage =
            typeof error.error === 'string'
              ? error.error
              : error.message;
      }
    }

    console.error('Authentication Service Error:', error);

    return throwError(() => new Error(errorMessage));
  }
}