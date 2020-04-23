import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isWishListCollapsed = false;
  isCategoriesCollapsed = false;
  isPortfolioCollapsed = false;
  isProdottoCollapsed = false;
  isProgressCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  wishlistsCollapse(){
    if(this.isWishListCollapsed===false){
      this.isWishListCollapsed = true;
    }
    else {
      this.isWishListCollapsed = false;
    }
  }

  categoriesCollapse(){
    if(this.isCategoriesCollapsed===false){
      this.isCategoriesCollapsed = true;
    }
    else{
      this.isCategoriesCollapsed = false;
    }
  }

  portfolioCollapse(){
    if(this.isPortfolioCollapsed===false){
      this.isPortfolioCollapsed = true;
    }
    else{
      this.isPortfolioCollapsed = false;
    }
  }

  prodottoCollapse(){
    if(this.isProdottoCollapsed ===false){
      this.isProdottoCollapsed = true;
    }
    else{
      this.isProdottoCollapsed = false;
    }
  }

  progressCollapse(){
    if(this.isProgressCollapsed===false){
      this.isProgressCollapsed = true;
    }
    else{
      this.isProgressCollapsed = false;
    }
  
  
  
  }


  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    
  }
  
   closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
  }

}
