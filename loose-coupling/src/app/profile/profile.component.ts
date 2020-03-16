import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { ProfileService } from 'src/app/shared/services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: Users;
  constructor(private router: Router,
    private profile: ProfileService) { }

  ngOnInit(): void {
  }

  //NEED TO ADD ROUTER FUNCTIONALITY TO THE BELOW METHOD SO USER
    //GETS ROUTED TO THEIR PROFILE (USER) PAGE AFTER SUBMITTING PROFILE INFO
  submit(): void {
    this.router.navigate(["questions"]);
  }
}
