package com.mycompany.myapp.exam11.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dto.Member;

@Component
public class Exam11MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberDao.class);
	public void insert(Member member){
		logger.info("dao insert");
	}
	
	public Member select(String mid){
		logger.info("dao select");
		return null;
	}
}
