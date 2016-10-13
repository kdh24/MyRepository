package com.mycompany.home.exam11.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.home.exam11.dto.Member;
import com.mycompany.home.exam11.service.Exam11MemberService;

@Controller
@RequestMapping("/exam11")
public class Exam11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);
	
	@Autowired
	Exam11MemberService memberService;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam11/index";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoinForm(){
		logger.info("memberJoin(GET) 처리");
		return "exam11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String memberJoin(Member member){
		logger.info("memberJoin(POST) 처리");
		logger.info("mid: " + member.getMid());
		logger.info("mname: " + member.getMname());
		logger.info("mpassword: " + member.getMpassword());
		logger.info("memail: " + member.getMemail());
		logger.info("mtel: " + member.getMtel());
		logger.info("mjob: " + member.getMjob());
		logger.info("mskill: " + Arrays.toString(member.getMskill()));
		logger.info("maddress1: " + member.getMaddress1());
		logger.info("maddress1: " + member.getMaddress2());
		logger.info("mbirth: " + member.getMbirth());
		
		memberService.join(member);
		return "redirect:/exam11/memberLogin";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)
		public String memberLoginForm(){
		logger.info("memberLogin(GET) 처리");
		return "exam11/memberLoginForm";
	}
	
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
		public String memberLogin(String mid, String mpassword){
		logger.info("memberLogin(POST) 처리");
		logger.info("mid: " + mid);
		logger.info("mpassword: " + mpassword);
		
		int result = memberService.login(mid, mpassword);
		if(result == Exam11MemberService.LOGIN_SUCCESS){
			return "redirect:/exam11/index";
		}else {
			return "redirect:/exam11/memberLogin";
		}
	}
	
	
	@RequestMapping(value="boardWrite", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("boardWrite(GET) 처리");
		
		return "exam11/boardWriteForm";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWrite(){
		logger.info("boardWrite(POST) 처리");
		
		return "redirect:/exam11/boardList";
	}
	
	@RequestMapping("boardList")
	public String boardList(){
		logger.info("boardList 처리");
		return "exam11/boardList";
	}
	
	
	
}
