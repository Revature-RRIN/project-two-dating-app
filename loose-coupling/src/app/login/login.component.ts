import { Component, OnInit } from "@angular/core";

import { Router } from "@angular/router";
import { MatDialog } from "@angular/material/dialog";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  constructor(private router: Router){
  }

  username: string;
  password: string;

  ngOnInit(): void {}
  

  // change this setup to rxie branch's?
  login(): void {
    if (this.username == "admin" && this.password == "pass") {
      this.router.navigate(["profile"]);
    } else {
      alert("Invalid credentials");
    }
  }


}
