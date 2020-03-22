package com.revature.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.LoginInfo;
import com.revature.beans.Matches;
import com.revature.beans.Messages;
import com.revature.beans.Users;
import com.revature.services.MatchesService;
import com.revature.services.MessagesService;
import com.revature.services.UsersService;
import com.revature.services.UsersServiceHibernate;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MessagesController {
	@Autowired
	private MessagesService ms;
	
	@PostMapping(value="/displayMessages")
	public ResponseEntity<Set<Messages>> getConversationByUsers(@RequestBody Users u) {
		Set<Messages> returnThis = ms.getConversationByUsers(u, u);
		returnThis.addAll(ms.getConversationByUsers(u, u));
		return ResponseEntity.ok(returnThis);
	}
	
	@PostMapping(value="/messages")
	public ResponseEntity<Integer> addMessage(@RequestBody Messages msg) {
		msg.setReceiver(msg.getSender());
		return ResponseEntity.status(201).body(ms.addMessage(msg));
	}

	
	@PutMapping(value="{messageId}")
	public ResponseEntity<Messages> updateMessage(@PathVariable("messageId") int id, @RequestBody Messages msg) {
		// possible error handling?
		ms.updateMessages(msg);
		return ResponseEntity.ok(ms.getMessageById(id));
	}
	
	@DeleteMapping(value="{messageId}")
	public ResponseEntity<Void> deleteMessage(@PathVariable("messageId") int id) {
		ms.deleteMessage(ms.getMessageById(id));
		return ResponseEntity.noContent().build();
	}
}