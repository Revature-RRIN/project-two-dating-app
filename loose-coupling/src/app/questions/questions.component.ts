import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { Users } from '../users';
import { Router } from "@angular/router";
import { UploadResponsesService } from '../services/uploadResponsess.service';
=======
import { Router } from '@angular/router';
>>>>>>> fef722ec2e4a047c5922951de92b7546d0dc2c9a

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

<<<<<<< HEAD
  constructor(private router: Router,
              private uploadResponse: UploadResponsesService) { }
=======
  constructor(private router: Router) { }
>>>>>>> fef722ec2e4a047c5922951de92b7546d0dc2c9a

  ngOnInit(): void {
  }

<<<<<<< HEAD
  submit(): void {
    //NEED TO UPLOAD ANSWERS TO JAVA
    updateAnswers() {};
    /////////////////////
    this.router.navigate(["user"]);
  }
=======
  questionSubmission()  {
    this.router.navigate(["dashboard"]);
  }

>>>>>>> fef722ec2e4a047c5922951de92b7546d0dc2c9a
}
