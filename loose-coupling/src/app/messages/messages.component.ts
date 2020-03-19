import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Messages } from '../shared/classes/messages';
import { MessageService } from '../shared/services/message.service';
import { Currentuser } from '../shared/classes/currentuser';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  public loggedUser: Currentuser;
  @Input() messages: Messages;
  @Output() submitted = new EventEmitter<Messages>();

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
    
  }


  /*
a. FIND MATCHES (get all "users" I match with)
b. For EACH user I match with, generate a new "Conversation" component, which had in it all the messages they have


*/



  displayMessages() {
this.messageService.viewMessages(this.loggedUser.user).subscribe(
  resp=>  {
    this.messages = resp;
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
}
