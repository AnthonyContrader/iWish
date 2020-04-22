import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ProdottoComponent } from './prodotto/prodotto.component';
import {WishlistsComponent} from './wishlists/wishlists.component';
import {CategoriesComponent} from './categories/categories.component';
import {PortfolioComponent} from './portfolio/portfolio.component';
import {ProgressComponent} from './progress/progress.component';
/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, ProdottoComponent, WishlistsComponent, CategoriesComponent, PortfolioComponent, ProgressComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
