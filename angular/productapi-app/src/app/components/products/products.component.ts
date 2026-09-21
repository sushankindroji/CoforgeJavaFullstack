import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../../model/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  message: string = '';

  constructor(
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(): void {
    this.productService.getProductList().subscribe({
      next: (data) => {
        this.products = data;
      },
      error: (err) => {
        console.error(err);
        this.message = 'Failed to load products.';
      }
    });
  }

  addProduct(): void {
    this.router.navigate(['/add-product/_add']);
  }

  productDetails(pid: number): void {
    this.router.navigate(['/product-details', pid]);
  }

  editProduct(pid: number): void {
    this.router.navigate(['/add-product', pid]);
  }

  deleteProduct(pid: number): void {

    if (confirm('Are you sure you want to delete this product?')) {

      this.productService.deleteProduct(pid).subscribe({

        next: () => {
          this.message = 'Product deleted successfully!';
          this.reloadData();
        },

        error: (err) => {
          console.error(err);
          this.message = 'Failed to delete product!';
        }

      });

    }

  }

}