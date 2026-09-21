import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-dealer-list',
  imports: [CommonModule],
  templateUrl: './dealer-list.component.html',
  styleUrl: './dealer-list.component.css'
})
export class DealerListComponent {
  dealerList: any[] = []; //Array to store list of dealers
  errorMessage: string = '';
  loading: boolean = false; // Optional: Add loading state

  constructor(private authService:AuthenticationService) { }

  ngOnInit(): void {
    // Fetch dealer information on component initialization
    this.loading = true; // Optional: Start loading
    this.errorMessage = '';
    
    this.authService.getDealerInfo().subscribe({
      next: (data: any[]) => {
        this.dealerList = data; // Populate dealerList with the retrieved data
        console.log('Dealer data fetched successfully', data);
        this.loading = false; // Optional: Stop loading
      },
      error: (error) => {
        this.errorMessage = 'Error fetching dealer data';
        console.error('Error:', error);
        this.loading = false; // Optional: Stop loading
      },
      complete: () => {
        // Optional: Code that runs after observable completes
        console.log('Dealer info fetch completed');
        this.loading = false; // Ensure loading stops
      }
    });
}

// Add to your component class

// Get unique cities count
getUniqueCities(): number {
  if (!this.dealerList || this.dealerList.length === 0) {
    return 0;
  }
  const uniqueCities = new Set(this.dealerList.map(dealer => dealer.city));
  return uniqueCities.size;
}

// Get today's date formatted
getTodayDate(): string {
  return new Date().toLocaleDateString('en-US', {
    month: 'short',
    day: 'numeric',
    year: 'numeric'
  });
}

}
