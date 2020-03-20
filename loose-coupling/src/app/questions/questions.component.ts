import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit, Input } from '@angular/core';
import { QuestionService } from '../shared/services/question.service';
import { Questions } from '../shared/classes/questions';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Input() questions: Questions[];
  

  constructor(private questionsServices: QuestionService) { }

  ngOnInit(): void {

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
    
  }

}
