import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { DatabindingComponent } from './databinding/databinding.component';
import { PipesdemoComponent } from './pipesdemo/pipesdemo.component';
import { DirectivesdemoComponent } from './directivesdemo/directivesdemo.component';
import { SuccessComponent } from './success/success.component';
import { ContactComponent } from './contact/contact.component';
import { DetailsComponent } from './details/details.component';
import { ShoppingComponent } from './shopping/shopping.component';


/**
 * Router configuration for the application. 
 * Routes are definded here for various components and modules in the application.
 */

export const routes: Routes = [
    { path: '', component:HomeComponent},
    { path: 'aboutus', component:AboutusComponent},
    { path: 'ajax', component:DatabindingComponent},
    { path: 'pipes', component:PipesdemoComponent},
    { path: 'dir', component:DirectivesdemoComponent},
    { path: 'dir19', loadComponent: () => import('./directivesdemo19/directivesdemo19.component').then(m => m.Directivesdemo19Component)},
    { path: 'login', loadComponent: () => import('./login/login.component').then(m => m.LoginComponent)},
    { path: 'dashboard', component:SuccessComponent},
    { path: 'contact', component:ContactComponent},
    { path: 'det', component:DetailsComponent},
    { path: 'shop', component:ShoppingComponent},

  
];

