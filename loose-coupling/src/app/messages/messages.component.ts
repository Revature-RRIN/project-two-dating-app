import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Messages } from '../shared/classes/messages';
import { MessageService } from '../shared/services/message.service';
import { Router } from '@angular/router';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  private message: Messages;


  users: Users;
  @Input() messages: Messages;
  @Output() submitted = new EventEmitter<Messages>();
  remark: string;

  constructor(private messageService: MessageService,
    private router: Router, private us : UsersService) {

      this.message = {
      messagesId: 0,
      remark: 'null',
      senderId: 0,
      receiverId: 0
      }
    }




  messageList: Messages[];

  messageArray = ['Hey jenny', 'hey frank', 'will you go out with me', 'no my parents say im not old enough to date', 'ok bye', 'ok by'];

  ngOnInit(): void {
    this.users = this.us.getUser();
  }


  /*
a. FIND MATCHES (get all "users" I match with)
b. For EACH user I match with, generate a new "Conversation" component
c. get ALL the MESSAGES where sender is thisuser and receiver is matched user
c2. get all the messages where sender is matched user and receiver is this user
put together

*/



  displayMessages() {
this.messageService.viewMessages(this.users).subscribe(
  resp=>  {
    this.messageList = resp;
  }
)
  }
/*
  messagesId: number;
  senderId: number;
  receiverId: number;
  remark: string;
*/
  sendMessage(): void {
    this.message.remark = this.remark;
    this.message.senderId = 1;//this.users.usersId;
  this.message.receiverId = 2;//"matched user id";
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
}
