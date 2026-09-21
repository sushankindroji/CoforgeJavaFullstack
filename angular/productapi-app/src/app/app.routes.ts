import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductsComponent } from './components/products/products.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProductSearchComponent } from './components/product-search/product-search.component';
import { DealerListComponent } from './components/dealer-list/dealer-list.component';
import { DealerRegistrationComponent } from './components/dealer-registration/dealer-registration.component';
import { LoginDealerComponent } from './components/login-dealer/login-dealer.component';
import { LogoutComponent } from './components/logout/logout.component';

export const routes: Routes = [

    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'products', component: ProductsComponent },
    { path: 'add-product/:pid', component: CreateProductComponent },
    { path: 'product-details/:pid', component: ProductDetailsComponent },
    { path: 'search', component: ProductSearchComponent },

    { path: 'dealers', component: DealerListComponent },
    { path: 'register', component: DealerRegistrationComponent },
    { path: 'login', component: LoginDealerComponent },
    { path: 'aboutus', component: AboutusComponent },
    { path: 'logout', component: LogoutComponent },

];
