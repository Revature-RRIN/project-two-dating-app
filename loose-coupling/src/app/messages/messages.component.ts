import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Messages } from '../shared/classes/messages';
import { MessageService } from '../shared/services/message.service';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  @Input() messages: Messages;
  @Output() submitted = new EventEmitter<Messages>();

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
    
  }

  displayMessages() {

  }

  sendMessage(): void {
  this.messageService.sendMessage(this.messages).subscribe(
    messages => {
      this.messages = messages;
      this.submitted.emit(messages);
    }
  );
}
}
