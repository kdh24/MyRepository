package com.mycompany.home.exam11.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam11")
public class Exam11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam11Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam11/index";
	}
	
	@RequestMapping("/memberJoin")
	public String memberJoin(){
		logger.info("memberJoin(GET) 처리");
		return "exam11/memberJoinForm";
	}
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.GET)
		public String memberLoginForm(){
		logger.info("memberLogin(GET) 처리");
		return "exam11/memberLoginForm";
	}
	
	
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
		public String memberLogin(){
		logger.info("memberLogin(POST) 처리");
		return "redirect:/exam11/memberLogin";
	}
	
}
