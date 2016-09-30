package com.mycompany.home.exam03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam03Controller {
	
	private static Logger logger = LoggerFactory.getLogger(Exam03Controller.class);
	
	@RequestMapping("/exam03/index")
	public String index() {
		logger.info("index 요청");
		return "exam03/index";
	}
}
