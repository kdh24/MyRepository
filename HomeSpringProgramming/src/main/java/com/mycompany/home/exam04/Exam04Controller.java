package com.mycompany.home.exam04;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Exam04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);

	@RequestMapping("/exam04/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam04/index";
	}
	
	@RequestMapping(value="/exam04/join", method=RequestMethod.GET)
	public String joinFrom(){
		logger.info("joinForm 요청 처리");
		return "exam04/joinform";
	}
	
	@RequestMapping(value="/exam04/join", method=RequestMethod.POST)
	public String join(Member member){
		logger.info("join 요청 처리");
		
		logger.info("mid: " + member.getMid());
		logger.info("mname: " + member.getMname());
		logger.info("mpassword: " + member.getMpassword());
		logger.info("memail: " + member.getMemail());
		logger.info("mtel: " + member.getMtel());
		logger.info("mjob: " + member.getMjob());
		logger.info("mskill: " + Arrays.toString(member.getMskill()));
		logger.info("maddress1: " + member.getMaddress1());
		logger.info("maddress2: " + member.getMaddress2());
		logger.info("mbirth: " + member.getMbirth());
		
		return "exam04/index";
	}
}
