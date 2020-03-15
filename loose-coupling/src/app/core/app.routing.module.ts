import { NgModule } from "@angular/core";

import { RouterModule, Routes } from "@angular/router";
import { UserComponent } from "../user/user.component";
import { LoginComponent } from "../login/login.component";
import { RegisterComponent } from "../register/register.component";
import { NavbarComponent } from "../navbar/navbar.component";
import { WelcomeComponent } from "../welcome/welcome.component";
import { ProfileComponent } from "../profile/profile.component"
import { QuestionsComponent } from '../questions/questions.component';
import { DashboardComponent } from '../dashboard/dashboard.component';

const routes: Routes = [
  { path: "user", component: UserComponent },
  { path: "login", component: WelcomeComponent },
  { path: "", component: WelcomeComponent },
  { path: "profile", component: ProfileComponent },
  { path: "questions", component: QuestionsComponent },
  { path: "dashboard", component: DashboardComponent }
  
  

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {}
