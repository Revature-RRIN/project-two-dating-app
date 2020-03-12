package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Matches;

@Repository
public interface MatchesDAO extends JpaRepository<Matches, Integer>{}
