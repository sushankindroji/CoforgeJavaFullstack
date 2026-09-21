import { Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { CustomerRegistrationComponent } from './customer-registration/customer-registration.component';

export const routes: Routes = [
    
    {path:'customers',component:CustomerComponent},
    {path:'register',component:CustomerRegistrationComponent},
    {path:'**',redirectTo:''},
];
