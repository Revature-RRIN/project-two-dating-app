package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Answers;

@Repository
public interface AnswersDAO extends JpaRepository<Answers, Integer>{}
