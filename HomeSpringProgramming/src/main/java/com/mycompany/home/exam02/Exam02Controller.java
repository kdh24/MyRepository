package com.mycompany.home.exam02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam02Controller {
	private static Logger logger = LoggerFactory.getLogger(Exam02Controller.class);
	
	@RequestMapping("/exam02/index")
	public String index(){
		logger.info("index 요청");
		return "exam02/index";
	}
	
	@RequestMapping("/exam02/join")
	public String join(String mid, String mname, String mage){
		logger.info("join 요청");
		logger.info("mid: " + mid);
		logger.info("mname: " + mname);
		logger.info("mage: " + mage);
		return "exam02/index";
	}
}
