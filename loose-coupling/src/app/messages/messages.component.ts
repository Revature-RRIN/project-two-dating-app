import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Messages } from '../shared/classes/messages';
import { MessageService } from '../shared/services/message.service';
import { Router } from '@angular/router';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';
import { Currentuser } from '../shared/classes/currentuser';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  private message: Messages;
  condition: boolean = false;


  users: Users;
  @Input() messages: Messages;
  @Output() submitted = new EventEmitter<Messages>();
  remark: string;

  currentUser: Currentuser;

  constructor(private messageService: MessageService,
    private router: Router, private us: UsersService) {

    this.message = {
      messagesId: null,
      remark: 'null',
      senderId: null,
      receiverId: null
    }
  }

  messageList: Messages[];

  ngOnInit(): void {

    //    this.users = this.us.getUser();

    //what I'll need                    ^^^
    //fake login cuz its easier for now vvv

    this.us.login('admin', 'pass').subscribe(
      resp => {
        this.currentUser = resp;
      }
    )

  }

  /*
a. FIND MATCHES (get all "users" I match with)
b. For EACH user I match with, generate a new "Conversation" component
c. get ALL the MESSAGES where sender is thisuser and receiver is matched user
c2. get all the messages where sender is matched user and receiver is this user
put together

*/



  displayMessages() {

    this.messageService.viewMessages(this.currentUser.user).subscribe(
      resp => {
        //        resp = this.messageList.sort((a, b) => a.messagesId < b.messagesId ? -1 : a.messagesId > b.messagesId ? 1 : 0);

        this.messageList = resp.sort((a, b) => a.messagesId < b.messagesId ? -1 : a.messagesId > b.messagesId ? 1 : 0);
      }
    )
      //this.condition = (this.message.senderId.usersId == this.currentUser.user.usersId);

  }
  /*
    messagesId: number;
    senderId: number;
    receiverId: number;
    remark: string;
  */
  sendMessage(): void {
    this.message.remark = this.remark;
    this.message.senderId = this.currentUser.user;//this.users;
    this.message.receiverId = this.currentUser.user;//"matched user";
    this.messageService.sendMessage(this.message).subscribe(
      messages => {
        this.messages = messages;
        this.submitted.emit(messages);
      }
    );
  }
  returnProfile(): void {
    this.router.navigate(["user"]);
  }

  reportUser() {
    // change user status to "reported"
    // which will then show to admin
  }

  meetUp() {
    //move match status to - one has pressed meet up, and if both have, then meet up "text" is send FROm senderID to Receiver
  }

}
