import { Users } from './users';
import { Status } from './status';

export class Matches {
  matchesId: number;
  user1Id: Users;
  user2Id: Users;
  matchStatus: Status;
  matchMessages: number;
}
