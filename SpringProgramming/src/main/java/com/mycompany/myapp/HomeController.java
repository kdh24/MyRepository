package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")	//context root 뒤의 / 다음 내용을 찾아 실행 해준다.
	public String home() {
		System.out.println("home() 실행1");	// 이거 같은 경우는 개발 후에 다 지워야 한다.
		logger.debug("home() 실행");	// 로그에 출력 -> 프로젝트가 실행되면 로그에 이게 뜬다.
									// 이것을 실행시키면 info 레벨에서 어느 클래스가 실행 시켰는지 보여준다.(현재는 HomeController)
									// 로그의 경우 안 지워도 출력 안되게 할 수 있다
									// 메소드 이름에 따라 로그 레벨이 달라진다.
									// main/resources 의 log4j.xml 의 level value 에서 지정할 수 있다.
		return "home";	// 이 이름과 views 폴더의 jsp 파일 이름이 같아야 한다.
	}
	
	@RequestMapping("/news")
	public String news(){
		logger.debug("news() 실행");	
		return "news";
	}
}
