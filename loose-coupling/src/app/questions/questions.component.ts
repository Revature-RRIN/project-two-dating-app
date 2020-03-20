import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/services/users.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  users: Users;
  constructor(private router: Router,
    private us : UsersService) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
  }

  submit(): void {
    //NEED TO UPLOAD ANSWERS TO JAVA
    //updateAnswers() {};
    /////////////////////
    this.router.navigate(["user"]);
  }


  questionSubmission()  {
    this.router.navigate(["user"]);    
  }

}
