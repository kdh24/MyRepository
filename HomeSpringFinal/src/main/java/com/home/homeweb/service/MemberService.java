package com.home.homeweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.homeweb.dao.MemberDao;
import com.home.homeweb.dto.Member;

@Component
public class MemberService {
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = -1;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL_MID = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL = 1;
	
	@Autowired
	private MemberDao memberDao;
	
	public int join(Member member){
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	public int login(String mid, String mpassword){
		Member member = memberDao.selectByMid(mid);
		if(member == null) { return LOGIN_FAIL_MID; }
		if(member.getMpassword().equals(mpassword) == false) { return LOGIN_FAIL_MPASSWORD; }
		return LOGIN_SUCCESS;
	}
	
	public int logout(String mid){
		return LOGOUT_SUCCESS;
	}
	
	public Member info(String mid, String mpassword) {
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false) return null;
		return member;
	}
	
	public boolean isMid(String mid){
		Member member = memberDao.selectByMid(mid);
		if(member == null) return false;
		return true;
	}
}
