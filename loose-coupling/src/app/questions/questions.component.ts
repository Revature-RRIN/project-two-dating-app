import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { QuestionService } from '../shared/services/question.service';
import { Questions } from '../shared/classes/questions';
import { UsersService } from '../shared/services/users.service';
import { Answers } from '../shared/classes/answers';
import { ProfileService } from '../shared/services/createprofile.service';
import { Score } from '../shared/classes/score';

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

  score: Score;

  constructor(private questionsServices: QuestionService,private router: Router,
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
    // this.ps.updateProfile(this.users).subscribe(
    //   users => {
    //     this.users = users;
       
        this.router.navigate(["question2"])
      // }
    // );
    //this.router.navigate(["user"]);
  } 
      

  /*questionSubmission()  {
        
  }
*/
}
