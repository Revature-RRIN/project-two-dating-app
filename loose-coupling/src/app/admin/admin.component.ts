import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';
import { BanuserService } from '../shared/services/banuser.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  users: Users;
  usArr: Users[];

  constructor(private us: UsersService,
    private bus: BanuserService,
    private router: Router) { }

  isBanClicked: boolean = false;

  ngOnInit(): void {
    this.users = this.us.getUser();
  }

  addQuestions(): void {

  }

  showBan()  {
    
    this.isBanClicked = true;
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
