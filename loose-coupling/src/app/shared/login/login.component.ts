import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../classes/currentuser';
import { UsersService } from '../services/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loggedUser: Currentuser;
  public username: string;
  public password: string;

  constructor(private usersService: UsersService,
    private router: Router) { }

  ngOnInit() {
    this.usersService.login(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      },
      error => {
        this.loggedUser = null;
      }
    );
  }

  login() {
    this.usersService.login(this.username, this.password).subscribe(
      resp => {
        this.loggedUser = resp;
        this.router.navigate(["user"])
      }
    );
  }

  logout() {
    this.usersService.logout().subscribe(
      resp => {
        this.loggedUser = null;
      }
    );
  }
}
