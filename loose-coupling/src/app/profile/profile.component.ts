import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { ProfileService } from 'src/app/shared/services/createprofile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  users: Users;
  constructor(private router: Router,
    private profile: ProfileService) { }

  ngOnInit(): void {
  }

  updateProfile() {
    this.router.navigate(["questions"]);
  }
}
