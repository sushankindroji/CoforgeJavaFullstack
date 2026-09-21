import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer',
  imports: [CommonModule],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {
  customers: Customer[] = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getCustomers().subscribe({
      next: (data) => {
        console.log("API Response:", data);
        this.customers = data;
        console.log("Customers Array:", this.customers);
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  getImage(image: string): string {

    if (!image) {
      return 'assets/no-image.png';
    }

    return `data:image/jpeg;base64,${image}`;
  }

  downloadPassport(passport?: string, firstName?: string): void {

    if (!passport) return;

    const link = document.createElement('a');
    link.href = `data:application/pdf;base64,${passport}`;
    link.download = `${firstName}-passport.pdf`;
    link.click();

  }
}
