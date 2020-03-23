import { Component, OnInit, Input, Output } from '@angular/core';
import { Questions } from '../shared/classes/questions';
import { Answers } from '../shared/classes/answers';
import { Users } from '../shared/classes/users';
import { EventEmitter } from 'protractor';
import { QuestionService } from '../shared/services/question.service';
import { Router } from '@angular/router';
import { UsersService } from '../shared/services/users.service';
import { ProfileService } from '../shared/services/createprofile.service';
import { Score } from '../shared/classes/score';

@Component({
  selector: 'app-question3',
  templateUrl: './question3.component.html',
  styleUrls: ['./question3.component.css']
})
export class Question3Component implements OnInit {

 

  @Input() questions: Questions[];
  answers  : Answers;
  users: Users;
  // @Output() submitted = new EventEmitter<Answers>();

  score: Score;

  constructor(private questionsServices: QuestionService,
    private router: Router,
    private us : UsersService,
    private ps: ProfileService) { }

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
    this.ps.updateProfile(this.users).subscribe(
      users => {
        this.users = users;
        this.router.navigate(["user"])
      }
    );
    //this.router.navigate(["user"]);
  } 
      

  /*questionSubmission()  {
        
  }
*/
}