import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {
 private apiURL='https://fakestoreapi.com/products';

  //DI HttpClient - Module to connect REST API

  constructor(private http:HttpClient) { }

  
helloService(){
    return "Hello from Angular Service using HttpClient";
  }

  // Method to fetch products from the API
    //Observable Return Type - async data handling 

    getProducts():Observable<Product[]>{
      return this.http.get<Product[]>(this.apiURL); // http get request.
    }
}
