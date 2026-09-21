import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShoppingService } from '../shopping.service';
import { Product } from '../product';

@Component({
  selector: 'app-shopping',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './shopping.component.html',
  styleUrl: './shopping.component.css'
})
export class ShoppingComponent implements OnInit {
  products: Product[] = [];
  myData: string = '';

  constructor(private shoppingService: ShoppingService) {}

  ngOnInit(): void {
    this.myData = this.shoppingService.helloService();
    this.shoppingService.getProducts().subscribe(data => {
      this.products = data;
    });
  }
}
