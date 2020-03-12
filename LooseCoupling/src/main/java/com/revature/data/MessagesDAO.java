package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Messages;

@Repository
public interface MessagesDAO extends JpaRepository<Messages, Integer>{}
