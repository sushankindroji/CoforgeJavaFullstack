import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { CustomerRegister } from './customer-register';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

   private apiUrl = 'http://localhost:8089/client/customers';

  constructor(private http: HttpClient) { }

  /**
   * Get all customers
   */
  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.apiUrl);
  }

  saveCustomer(formData: FormData): Observable<CustomerRegister> {
    return this.http.post<CustomerRegister>(this.apiUrl, formData);
  }

}
