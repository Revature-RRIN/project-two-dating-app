import { Component, OnInit } from '@angular/core';
import { Users } from '../users';
import { Router } from "@angular/router";
import { UploadResponsesService } from '../services/uploadResponsess.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor(private router: Router,
              private uploadResponse: UploadResponsesService) { }

  ngOnInit(): void {
  }

  submit(): void {
    //NEED TO UPLOAD ANSWERS TO JAVA
    updateAnswers() {};
    /////////////////////
    this.router.navigate(["user"]);
  }
}
