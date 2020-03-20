import { Component, OnInit } from '@angular/core';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  users: Users;
  constructor(private us: UsersService) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
  }

  deleteUser(): void {
    
  }

  addQuestions(): void {

  }
}
