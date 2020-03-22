package com.revature.controller;

import java.util.Set;

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

import com.revature.beans.Matches;
import com.revature.beans.Users;
import com.revature.services.MatchesService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MatchesController {
	@Autowired
	private MatchesService ms;
	
	@GetMapping(value="/matches/{matchId}")
	public ResponseEntity<Matches> getMatchById(Integer id) {
		return ResponseEntity.ok(ms.getMatchById(id));
	}
	
	@GetMapping(value="/matches")
	public ResponseEntity<Set<Matches>> getMatches() {
		return ResponseEntity.ok(ms.getAllMatches());
	}
	
	/*
	 * @PostMapping(value="/matches") public ResponseEntity<Integer>
	 * addMatch(@RequestBody Matches m) { return
	 * ResponseEntity.status(201).body(ms.addMatch(m)); }
	 */
	
	@PostMapping(value="/matches")
	public ResponseEntity<Matches> findMatch(@RequestBody Users u) {
		return ResponseEntity.status(201).body(ms.matchCompatibleUser(u));
	}

	
	@PutMapping(value="/matches/{matchId}")
	public ResponseEntity<Matches> updateMatch(@PathVariable("matchId") int id, @RequestBody Matches m) {
		// possible error handling?
		ms.acceptMatch(m);
		return ResponseEntity.ok(ms.getMatchById(id));
	}
	
	@DeleteMapping(value="/matches/{matchId}")
	public ResponseEntity<Void> deleteMatch(@PathVariable("matchId") int id) {
		ms.deleteMatch(ms.getMatchById(id));
		return ResponseEntity.noContent().build();
	}
}
