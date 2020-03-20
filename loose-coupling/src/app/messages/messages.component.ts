import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Messages } from '../shared/classes/messages';
import { MessageService } from '../shared/services/message.service';
import { Currentuser } from '../shared/classes/currentuser';
import { Router } from '@angular/router';
import { Users } from '../shared/classes/users';
import { UsersService } from '../shared/services/users.service';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  public loggedUser: Currentuser;
  @Input() messages: Messages;
  @Output() submitted = new EventEmitter<Messages>();

  constructor(private messageService: MessageService,
    private router: Router) { }
  messageList: Messages[];


  messageArray = ['Hey jenny', 'hey frank', 'will you go out with me', 'no my parents say im not old enough to date', 'ok bye', 'ok by'];





  ngOnInit(): void {
  }


  /*
a. FIND MATCHES (get all "users" I match with)
b. For EACH user I match with, generate a new "Conversation" component
c. get ALL the MESSAGES where sender is thisuser and receiver is matched user
c2. get all the messages where sender is matched user and receiver is this user
put together

*/



  displayMessages() {
this.messageService.viewMessages(this.loggedUser.user).subscribe(
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
  this.messageService.sendMessage(this.messages).subscribe(
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
