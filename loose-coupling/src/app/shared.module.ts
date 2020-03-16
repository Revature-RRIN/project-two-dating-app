import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UrlService } from './services/url.service';
import { UsersService } from './services/users.service';
import { NavbarComponent } from './navbar/navbar.component';
//import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
//import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [NavbarComponent], //, LoginComponent],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [
    UrlService,
    UsersService
  ],
  exports: [
    NavbarComponent
  ]
})
export class SharedModule { }
