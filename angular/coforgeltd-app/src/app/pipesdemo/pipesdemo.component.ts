import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-pipesdemo',
  imports: [CommonModule],
  templateUrl: './pipesdemo.component.html',
  styleUrl: './pipesdemo.component.css'
})
export class PipesdemoComponent {
  //String
   title = 'Coforge Tehnologies';  

   //date Object
  todaydate = new Date();  

  //json Object
  jsonval = {name: 'Alex', age: '25', address:{a1: 'Paris', a2: 'France'}};  

  //array Object
  months = ['Jan', 'Feb', 'Mar', 'April', 'May', 'Jun',  
    'July', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec'];  
}
