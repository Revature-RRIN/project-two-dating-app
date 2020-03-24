import { Component, OnInit, EventEmitter, Output, Input, OnChanges } from '@angular/core';
import { Messages } from '../shared/classes/messages';
import { MessageService } from '../shared/services/message.service';
import { Router } from '@angular/router';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';
import { MatchesService } from '../shared/services/matches.service';
import { ProfileService } from '../shared/services/createprofile.service';
import { Matches } from '../shared/classes/matches';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit, OnChanges {
  myMatches: Matches[];

  private message: Messages;
  condition: boolean = false;
  thisMatch: Matches;


  @Input() messages: Messages;
  @Output() submitted = new EventEmitter<Messages>();
  remark: string;

  users: Users;
  matchedUser: Users;

  constructor(private messageService: MessageService,
    private router: Router, private us: UsersService, private ms: MatchesService, private ps: ProfileService) {

    this.message = {
      messagesId: null,
      remark: 'null',
      senderId: null,
      receiverId: null
    }
  }

  messageList: Messages[];

  ngOnInit(): void {
    this.users = this.us.getUser();
    this.getMatches();
  }

  ngOnChanges() {
    this.displayMessages();
  }


  getMatches() {
    this.users = this.us.getUser();
    console.log(this.users);
    this.ms.getMatches().subscribe(
      matches => {
        this.myMatches = matches;
      }
    )
  }


  public onChange(event): void {


    this.matchedUser = event.target.value;
    console.log(this.matchedUser);
  }

  displayMessages() {
    this.messageService.viewMessages(this.users, this.matchedUser).subscribe(
      resp => {
        this.messageList = resp.sort((a, b) => a.messagesId < b.messagesId ? -1 : a.messagesId > b.messagesId ? 1 : 0);
      }
    )
  }



  //this.condition = (this.message.senderId.usersId == this.currentUser.user.usersId);

  /*
    messagesId: number;
    senderId: number;
    receiverId: number;
    remark: string;


    signup(): void {
    this.signupService.signup(this.users).subscribe(
      users => {
        this.users = users;
        this.submitted.emit(users);
        this.router.navigate(["login"]);
      }
    );
  */
  sendMessage(): void {
    
    this.message.senderId = this.users;
    this.message.receiverId = this.matchedUser;
    this.messageService.sendMessage(this.message).subscribe(
      message => {
        this.message = message;
        this.submitted.emit(message);
      }
    );
  }
  returnProfile(): void {
    this.router.navigate(["user"]);
  }

  reportUser() {
    //    this.ps.updateProfile(this.matchedUser);
    // change user status to "reported"
    // which will then show to admin
  }

  meetUp() {
    //move match status to - one has pressed meet up, and if both have, then meet up "text" is send FROm senderID to Receiver

  }

}
