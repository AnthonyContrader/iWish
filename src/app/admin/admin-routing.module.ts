import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ProdottoComponent } from './prodotto/prodotto.component';
import {WishlistsComponent} from './wishlists/wishlists.component';
import {CategoriesComponent} from './categories/categories.component';
import {PortfolioComponent} from './portfolio/portfolio.component';
import {ProgressComponent} from './progress/progress.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'prodotto', component: ProdottoComponent},
    {path: 'wishlists', component: WishlistsComponent},
    {path: 'categories', component: CategoriesComponent},
    {path: 'portfolio', component: PortfolioComponent},
    {path: 'progress', component: ProgressComponent}
  ]},
 {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }