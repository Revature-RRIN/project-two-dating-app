import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UrlService } from './url.service';
import { UsersService } from './services/users.service';
import { NavBarComponent } from './nav-bar/nav-bar.component';
//import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
//import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [NavBarComponent], //, LoginComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [
    UrlService,
    UsersService
  ],
  exports: [
    NavBarComponent
  ]
})
export class SharedModule { }
