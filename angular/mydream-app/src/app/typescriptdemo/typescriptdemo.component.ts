import { Component, OnInit } from '@angular/core';

enum Role {
  Admin,
  User,
  Guest,
}

@Component({
  selector: 'app-typescriptdemo',
  standalone: true,
  imports: [],
  templateUrl: './typescriptdemo.component.html',
  styleUrl: './typescriptdemo.component.css'
})
export class TypescriptdemoComponent implements OnInit {

  // String
  studentName: string = "Rajashekar";

  // Number
  age: number = 35;
  price: number = 1999.99;

  // Boolean
  isTrainer: boolean = true;

  // Array
  marks: number[] = [85, 90, 78];
  subjects: string[] = ["Java", "Angular", "Spring Boot"];

  // Tuple
  employee: [number, string] = [101, "Ravi"];

  // Enum
  userRole: Role = Role.Guest;

  // Any
  randomValue: any = "Hello";

  // Unknown
  inputValue: unknown = "Test Data";

  // Union
  orderId: number | string = 101;

  // Literal
  status: "success" | "error" | "loading" = "success";

  // Object
  product = {
    id: 1,
    name: "Laptop",
    price: 55000
  };

  company: string;
  empId: number;
  name: string;

  constructor() {
    this.empId = 123;
    this.name = "Shiva";
    this.company = "Coforge Ltd";
  }

  ngOnInit(): void {
    console.log("Component Initialized");
    this.randomValue = 100;
  }

  addNumbers(num1: number, num2: number): number {
    return num1 + num2;
  }

  area(r: number): number {
    return Math.PI * r * r;
  }
}