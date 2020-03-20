import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit, Input } from '@angular/core';
import { QuestionService } from '../shared/services/question.service';
import { Questions } from '../shared/classes/questions';
import { UsersService } from '../shared/services/users.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Input() questions: Questions[];
  
  users: Users;
  constructor(private questionsServices: QuestionService,private router: Router,
    private us : UsersService) { }

  ngOnInit(): void {
    this.users = this.us.getUser();
    this.questionsServices.getQuestions().subscribe(
      questions => {
        this.questions = questions;
      }
    );
    }

  submit(): void {
    //NEED TO UPLOAD ANSWERS TO JAVA
    //updateAnswers() {};
    /////////////////////
    //this.router.navigate(["user"]);
  }


  questionSubmission()  {
    this.router.navigate(["user"]);    
  }

}
