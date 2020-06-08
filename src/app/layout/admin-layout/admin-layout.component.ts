import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { PortfolioDTO } from 'src/dto/portfoliodto';
import { PortfolioService } from 'src/service/portfolio.service';
import {UserService} from 'src/service/user.service';

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css']
})


export class AdminLayoutComponent implements OnInit {

  
  constructor(private portfolioservice: PortfolioService, private userservice: UserService ) { 
    
  }

  ngOnInit() {

  }
  

}
 



