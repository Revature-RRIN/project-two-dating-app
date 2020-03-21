import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';

@Component({
  selector: 'app-ban-users',
  templateUrl: './ban-users.component.html',
  styleUrls: ['./ban-users.component.css']
})
export class BanUsersComponent implements OnInit {

  constructor(private us: UsersService) { }
  users: Users;

  ngOnInit(): void {
    this.users = this.us.getUser();
  }

  banUser(u: Users): void {
    // remove the author from the book
  // this.users.splice(this.users.indexOf(u), 1);
    // this.book.authors.splice(this.book.authors.indexOf(a), 1);
  }

}
