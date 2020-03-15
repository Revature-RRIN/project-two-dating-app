import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(private router: Router) {
  }

  newUsername: string;
  newPassword: string;

  ngOnInit(): void {
  }

  register(): void {
    if (this.newUsername != undefined && this.newPassword != undefined) { 
      //NEED TO EVENTUALLY REMOVE THE ALERT BELOW
    alert(this.newUsername + " is username, and " + this.newPassword + " is password.");
    this.router.navigate(["profile"]);
    }
  }

}
