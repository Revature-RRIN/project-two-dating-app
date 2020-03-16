import { Component, OnInit } from '@angular/core';
import { Users } from '../Classes/users';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {

  constructor(user: Users) { }

  ngOnInit(): void {
  }

}
