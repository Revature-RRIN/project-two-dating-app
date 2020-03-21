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
import { QuestionService } from './shared/services/question.service';
import { AdminComponent } from './admin/admin.component';
import { BanUsersComponent } from './ban-users/ban-users.component';
import { MatchesComponent } from './matches/matches.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { MatchesService } from './shared/services/matches.service';

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
    MessagesComponent,
    AdminComponent,
    BanUsersComponent,
    MatchesComponent,
    NotificationsComponent
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
    ProfileService,
    QuestionService,
    MatchesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }