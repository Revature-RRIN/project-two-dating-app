import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';
import { Router } from '@angular/router';
import { MatchesService } from '../shared/services/matches.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  users: Users
  clickedMessage: boolean = false;
  @Output() submitted = new EventEmitter<Users>();

  constructor(private us : UsersService,
    private match: MatchesService,
    private router: Router) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
    if (this.users.usertype == 1) { 
          this.router.navigate(["admin"]);
        }
  }

  editProfile(): void {
    this.router.navigate(["profile"])
  }

  findMatch(): void {
    this.match.findMatch(this.users).subscribe(
      users => {
        this.users = users;
        this.submitted.emit(users);
        this.router.navigate(["matches"]);
      }
    );
  }

  viewMatches(): void {
    this.router.navigate(["matches"])
  }

  viewMessages(): void {
    this.clickedMessage = true;
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
