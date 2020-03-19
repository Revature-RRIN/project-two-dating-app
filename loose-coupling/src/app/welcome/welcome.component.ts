import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  isLogClicked: boolean = false;
  isSignClicked: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  showLogin() {
    this.isLogClicked = true;
  }

  showSignup()  {
    this.isSignClicked = true;
  }

}
