import { Users } from './users';

export class Messages {
  messagesId: number;
  sender: Users;
  receiver: Users;
  remark: string;
}
