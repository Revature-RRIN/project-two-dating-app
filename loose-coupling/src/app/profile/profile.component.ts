import { Component, OnInit } from '@angular/core';
import { Users } from '../users';
import { Router } from "@angular/router";
import { ProfileService } from '../services/profile.service';

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

  updateProfile() {
    this.router.navigate(["questions"]);
  }
}
