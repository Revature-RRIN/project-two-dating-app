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

//  setMatchedUser(matchedUser: Users) {
//    this.matchedUser = matchedUser;
//    return this.matchedUser;
//  }

  private message: Messages;
  condition: boolean = false;
  thisMatch: Matches;


  @Input() messages: Messages;
  @Input() matchedUser: Users;
  @Output() submitted = new EventEmitter<Messages>();
  remark: string;
  users: Users;

  constructor(private messageService: MessageService,
    private router: Router, private us: UsersService, private ms: MatchesService, private ps: ProfileService) {

    this.message = {
      messagesId: null,
      remark: 'null',
      sender: null,
      receiver: null
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

  match: Matches;
  public onChange(event): void {
    console.log(event.target.value);
    const userPass: string[] = event.target.value.split(" ", 2);
    const thisUsername: string = userPass[0];
    const thisPassword: string = userPass[1];

    this.us.login(thisUsername, thisPassword).subscribe(
      resp => {
        console.log(resp.user.firstname);
        this.matchedUser = resp.user;
      }
    );

  }

  displayMessages() {
    console.log(this.matchedUser.firstname);
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
    console.log(this.matchedUser.firstname);
    console.log("sending with the sender as . . . " + this.users.firstname);
    console.log("and the reciever being ... " + this.matchedUser.firstname);
    this.message.remark = this.remark;
    this.message.sender = this.users;
    this.message.receiver = this.matchedUser;

    console.log(this.message.sender);
    console.log(this.message.receiver);

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
