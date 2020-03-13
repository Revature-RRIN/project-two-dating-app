import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';

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
    //GETS ROUTED TO THEIR PROFILE (USER) PAGE AFTER SUBMITTING PROFILE INFO
  submit(): void {}
}
