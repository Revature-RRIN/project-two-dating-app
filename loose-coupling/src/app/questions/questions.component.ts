import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  submit(): void {
    //NEED TO UPLOAD ANSWERS TO JAVA
    //updateAnswers() {};
    /////////////////////
    this.router.navigate(["user"]);
  }


  questionSubmission()  {
    
  }

}
