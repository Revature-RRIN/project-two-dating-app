import { Component, OnInit } from '@angular/core';
import { Users } from '../users';
import { Router } from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: Users;
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  submit(): void {
    this.router.navigate(["questions"]);
  }
}
