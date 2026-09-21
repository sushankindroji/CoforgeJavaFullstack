import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../../model/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-product-search',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product-search.component.html',
  styleUrl: './product-search.component.css'
})
export class ProductSearchComponent {

  searchTerm: string = '';

  products: Product[] = [];

  message: string = '';

  constructor(private productService: ProductService) {}

  handleSearch(): void {

    if (this.searchTerm.trim() === '') {
      this.message = 'Please enter a product name.';
      this.products = [];
      return;
    }

    this.productService.searchProductByName(this.searchTerm).subscribe({

      next: (data: Product[]) => {
        this.products = data;

        if (this.products.length === 0) {
          this.message = 'No products found.';
        } else {
          this.message = '';
        }
      },

      error: (err: any) => {
        console.error(err);
        this.products = [];
        this.message = 'Error searching products.';
      }

    });

  }

}