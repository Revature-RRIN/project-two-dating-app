import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor() { }

  newUsername: string;
  newPassword: string;

  ngOnInit(): void {
  }
  
  register(): void {
    alert(this.newUsername + " is username, and " + this.newPassword + " is password.");
}

}
