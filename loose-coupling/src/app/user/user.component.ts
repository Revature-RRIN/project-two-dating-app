import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  users: Users
  clickedMessage: boolean = false;

  constructor(private us : UsersService,
    private router: Router) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
  }

  editProfile(): void {
    this.router.navigate(["profile"])
  }

  viewMessages(): void {
    this.clickedMessage = true;
  }
}
