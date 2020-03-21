import { Users } from './users';

export class Messages {
  messagesId: number;
  senderId: Users;
  receiverId: Users;
  remark: string;
}
