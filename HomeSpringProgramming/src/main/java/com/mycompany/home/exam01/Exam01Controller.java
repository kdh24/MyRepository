package com.mycompany.home.exam01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {

	private static Logger logger = LoggerFactory.getLogger(Exam01Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam01/index";
	}
	
	@RequestMapping("/login")
	public String login(){
		logger.info("login 요청 처리");
		return "exam01/login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		logger.info("logout 요청 처리");
		return "exam01/logout";
	}
}
