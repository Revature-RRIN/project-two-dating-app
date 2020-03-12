package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Questions;

@Repository
public interface QuestionsDAO extends JpaRepository<Questions, Integer>{}
