import { Matches } from './matches';
import { Messages } from './messages';

export class Users {
    usersId : number;
	usertype : number;
	username : string;
	pass : string;
	firstname : string;
	lastname : string;
	score : number;
	age : number;
	gender : string;
	location : string;
	banned : string;
	userMatches : Matches [];
	sentMessages : Messages [];
	receivedMessages : Messages [];
	//private Set<Matches> userMatches;
	//private Set<Messages> userMessages;
}
