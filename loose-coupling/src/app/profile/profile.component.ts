import { Component, OnInit } from '@angular/core';
import { Users } from '../users';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: Users;
  constructor() { }

  ngOnInit(): void {
  }

  //NEED TO ADD ROUTER FUNCTIONALITY TO THE BELOW METHOD SO USER
  //GETS ROUTED TO THE QUESTIONS/QUIZLET PAGE AFTER SUBMITTING PROFILE INFO
  submit(): void {}
}
