import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Users } from '../classes/users';
import { SignupService } from '../services/signup.service';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  @Input() users: Users;
  @Output() submitted = new EventEmitter<Users>();

  constructor(private signupService: SignupService,
    private router: Router,
    private us : UsersService) {
   }

  ngOnInit(): void {
    if (!this.users) {
      this.users = new Users();
    } else {this.users = this.us.getUser();}
}
  signup(): void {
    this.signupService.signup(this.users).subscribe(
      users => {
        this.users = users;
        this.submitted.emit(users);
        this.router.navigate(["login"]);
      }
    );
  }

}
