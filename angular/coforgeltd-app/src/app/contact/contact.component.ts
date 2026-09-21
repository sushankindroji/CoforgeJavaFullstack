import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {

  pname: string = '';
  pemail: string = '';
  pmessage: string = '';

  submittedData: any = null;

  constructor(private router: Router) {}

  onSubmit(): void {

    this.submittedData = {
      name: this.pname,
      email: this.pemail,
      message: this.pmessage
    };

    console.log('Submitted Data:', this.submittedData);

    // Navigate after 10 seconds
    setTimeout(() => {
      this.router.navigate(['/det'], {
        state: {
          data: this.submittedData
        }
      });
    }, 10000);

  }
}