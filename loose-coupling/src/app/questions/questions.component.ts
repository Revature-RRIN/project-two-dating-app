import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { QuestionService } from '../shared/services/question.service';
import { Questions } from '../shared/classes/questions';
import { UsersService } from '../shared/services/users.service';
import { Answers } from '../shared/classes/answers';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Input() questions: Questions[];
  answers  : Answers;
  users: Users;
  @Output() submitted = new EventEmitter<Answers>();

  constructor(private questionsServices: QuestionService,private router: Router,
    private us : UsersService) { }

  ngOnInit(): void {

    if (!this.answers) {
      this.answers = new Answers();
  }
      
    this.users = this.us.getUser(); 
    
    this.questionsServices.getQuestions().subscribe(
      questions => {
        this.questions = questions;
      }
    );
    }

  submit(): void {
    this.questionsServices.addAnswers(this.answers).subscribe(
      answers => {
        this.answers = answers;
        this.submitted.emit(answers);
        this.router.navigate(["user"]);
      }
    );
    //this.router.navigate(["user"]);
  } 
      

  /*questionSubmission()  {
        
  }
*/
}
