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
import { DashboardComponent } from './dashboard/dashboard.component';
import { QuestionsComponent } from './questions/questions.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ProfileService } from './shared/services/createprofile.service';
import { MessagesComponent } from './messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    ProfileComponent,
    SignupComponent,
    DashboardComponent,
    QuestionsComponent,
    WelcomeComponent,
    MessagesComponent
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
  providers: [
    SignupService,
    ProfileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }