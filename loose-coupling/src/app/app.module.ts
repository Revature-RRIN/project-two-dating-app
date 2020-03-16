import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';

import { UserComponent } from './user/user.component';
import { ProfileComponent } from './profile/profile.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { RegisterComponent } from './register/register.component';
import { UsersService } from './services/users.service';
import { LoginComponent } from './login/login.component';
import { SharedModule } from './shared.module';
import { NavbarComponent } from './navbar/navbar.component';
import { QuestionsComponent } from './questions/questions.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MessageService } from './services/message.service';
import { ProfileService } from './services/profile.service';
import { UrlService } from './services/url.service';
import { UploadResponsesService } from './services/uploadResponsess.service';
import { RegisterService } from './services/register.service';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    NavbarComponent,
    QuestionsComponent,
    DashboardComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    SharedModule
  ], 
  providers: [
    MessageService,
    ProfileService,
    UrlService,
    RegisterService,
    UploadResponsesService,
    UsersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }