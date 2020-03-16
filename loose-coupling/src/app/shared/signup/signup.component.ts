import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Users } from '../classes/users';
import { SignupService } from '../services/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  @Input() users: Users;
  @Output() submitted = new EventEmitter<Users>();

  constructor(private signupService: SignupService) {
   }

  ngOnInit(): void {
    if (!this.users) {
      this.users = new Users();
  }
}
  signup(): void {
    this.signupService.signup(this.users).subscribe(
      users => {
        this.users = users;
        this.submitted.emit(users);
      }
    );
  }

}
