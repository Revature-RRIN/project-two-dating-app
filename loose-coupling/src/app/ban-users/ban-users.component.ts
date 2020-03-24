import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';
import { Router } from '@angular/router';
import { BanuserService } from '../shared/services/banuser.service';

@Component({
  selector: 'app-ban-users',
  templateUrl: './ban-users.component.html',
  styleUrls: ['./ban-users.component.css']
})
export class BanUsersComponent implements OnInit {

  constructor(private us: UsersService,
    private router: Router,
    private bu: BanuserService) { }
  users: Users;
  banned: Users;

  usArr: Users[];

  ngOnInit(): void {
    this.users = this.us.getUser();
    this.bu.getAllUsers().subscribe(resp => this.usArr=resp);
  }

  deleteUser(banned: Users) {
    this.bu.deleteUser(banned).subscribe(
      banned => {
        // this.banned = banned;
        this.router.navigate(["login"]) 
      }
    );
    }
}
