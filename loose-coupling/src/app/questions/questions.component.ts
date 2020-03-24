import { Users } from '../shared/classes/users';
import { Router } from "@angular/router";
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { QuestionService } from '../shared/services/question.service';
import { Questions } from '../shared/classes/questions';
import { UsersService } from '../shared/services/users.service';
import { Answers } from '../shared/classes/answers';
import { Scores } from '../shared/classes/scores';
import { ProfileService } from '../shared/services/createprofile.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Input() //questions: Questions[];
  sum : number=0;
  q1 : number = 0;
  q2 : number =0;
  scores1  : Scores;
  scores2  : Scores;
  scores3  : Scores;
  users: Users;
  @Output() submitted = new EventEmitter<Users>();

  constructor(
    private questionsServices: QuestionService,
    private router: Router,
    private us : UsersService, 
    private ps:ProfileService) { }

  ngOnInit(): void {

    if (!this.scores1) {
      this.scores1=new Scores();
      this.scores2=new Scores();
      this.scores3=new Scores();
  }
  
  
  this.users = this.us.getUser();
     
    
    /*this.questionsServices.getQuestions().subscribe(
      questions => {
        this.questions = questions;
      }
    );*/
    }

    submit(){
      this.q1=0;
      this.q1= this.sum+ parseInt(this.scores1.qonescore) ;
      this.router.navigate(["questions"]);
      console.log(this.q1);
    }

    submit2(){
      this.q2= this.q1+parseInt(this.scores2.qtwoscore);
      this.router.navigate(["questions"]);
      console.log(this.q2); 
    } 

  submit3(): void {
    this.ps.updateProfile(this.users).subscribe(
       users => {
        this.users = users;
        this.submitted.emit(users);
        this.router.navigate(["user"]); 
      }
    );
    //this.router.navigate(["user"]);
  } 
      

  /*questionSubmission()  {
        
  }
*/
}
