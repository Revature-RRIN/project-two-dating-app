import { Component, OnInit } from '@angular/core';
import { UsersService } from '../services/users.service';
import { Router } from '@angular/router';
import { Users } from '../classes/users';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = 'Loose Coupling';

  users:Users;

  constructor(public router: Router, private us: UsersService) { }

  ngOnInit(): void {
  }

  logOut(): void {
    this.us.logout().subscribe(
      resp => {
        this.users = null;
      }
    );
    this.router.navigate(["login"])
  }

}

