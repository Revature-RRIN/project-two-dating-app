import { NgModule } from "@angular/core";

import { RouterModule, Routes } from "@angular/router";
import { UserComponent } from "../user/user.component";
import { LoginComponent } from "../login/login.component";
import { RegisterComponent } from "../register/register.component";
import { NavbarComponent } from "../navbar/navbar.component";
import { WelcomeComponent } from "../welcome/welcome.component";



const routes: Routes = [
  { path: "user", component: UserComponent },
  { path: "login", component: WelcomeComponent },
  { path: "", component: WelcomeComponent },
  { path: "", component: RegisterComponent },
  { path: "", component: LoginComponent },
  { path: "", component: NavbarComponent }
  
  

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {}
