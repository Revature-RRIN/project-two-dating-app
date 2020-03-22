package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Answers;
import com.revature.beans.Questions;
import com.revature.services.AnswerService;
import com.revature.services.QuestionService;

@RestController
@RequestMapping(value="/questions")
@CrossOrigin(origins="http://localhost:4200")
public class QuestionController {
	
	@Autowired
	private QuestionService qs;
	/*
	 * @Autowired private AnswerService as;
	 */
	
	
	  @GetMapping() public ResponseEntity<Set<Questions>> getAllQuestions() {
	  return ResponseEntity.ok(qs.getAllQuestions()); }
	 
	
	/*
	 * @PostMapping public ResponseEntity<Integer> addAnswer(@RequestBody Answers a)
	 * { System.out.println(a);
	 * 
	 * return ResponseEntity.status(201).body(as.addAnswers(a)); }
	 */
	
	
	
	  @DeleteMapping(value="{questionId}") public ResponseEntity<Void>
	  deleteQuestions(@PathVariable("questionId") Integer id) {
	  qs.deleteQuestions(qs.getQuestionById(id)); return
		  ResponseEntity.noContent().build(); 
	  }
	 
}