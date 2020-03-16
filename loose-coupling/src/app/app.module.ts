import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { SharedModule } from './shared/shared.module';

import { AppComponent } from './app.component';

import { LoginComponent } from './shared/login/login.component';
import { UserComponent } from './user/user.component';
import { ProfileComponent } from './profile/profile.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { CustomMaterialModule } from './material/material.module';
import { SignupComponent } from './shared/signup/signup.component';
import { SignupService } from './shared/services/signup.service';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    ProfileComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    CustomMaterialModule,
    SharedModule
  ], 
  providers: [SignupService],
  bootstrap: [AppComponent]
})
export class AppModule { }