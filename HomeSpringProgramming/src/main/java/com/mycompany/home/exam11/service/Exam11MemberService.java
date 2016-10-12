package com.mycompany.home.exam11.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.home.exam11.dao.Exam11MemberDao;
import com.mycompany.home.exam11.dto.Member;

@Component
public class Exam11MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11MemberService.class);
	
	@Autowired
	Exam11MemberDao memberDao;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	
	public void join(Member member){
		logger.info("join 처리");
		memberDao.insert(member);
	}
	
	public int login(String mid, String mpassword){
		logger.info("login 처리");
		Member member = memberDao.select(mid);
		if(member == null){
			return LOGIN_FAIL_MID;
		}else {
			if(member.getMpassword().endsWith(mpassword)){
				return LOGIN_SUCCESS;
			}else{
				return LOGIN_FAIL_MPASSWORD;
			}
		}
			
	}
}
