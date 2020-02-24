import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserAccountComponent } from './components/user-account/user-account.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ProductComponent } from './components/product/product.component';


const routes: Routes = [
{path: '', pathMatch: 'full', redirectTo: 'home'},
{path: 'home', component: HomeComponent},
{path: 'user-account', component: UserAccountComponent},
{path: 'login', component: LoginComponent},
{path: 'logout', component: LogoutComponent},
{path: 'register', component: RegisterComponent},
{path: 'products', component: ProductComponent},
{path: '**', component: NotFoundComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
