import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './shared/login/login.component';
import { SignupComponent } from './shared/signup/signup.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MessagesComponent } from './messages/messages.component';
import { QuestionsComponent } from './questions/questions.component';
import { UserComponent } from './user/user.component';
import { MatchesComponent } from './matches/matches.component';


const routes: Routes = [

  {path: "login", component: LoginComponent},
  {path: "profile", component: ProfileComponent},
  {path: "", component: WelcomeComponent},
  {path: "signup", component: SignupComponent},
  {path: "dashboard", component: DashboardComponent},
  {path: "questions", component: QuestionsComponent},
  {path: "user", component: UserComponent},
  {path: "messages", component: MessagesComponent},
  {path: "matches", component: MatchesComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 