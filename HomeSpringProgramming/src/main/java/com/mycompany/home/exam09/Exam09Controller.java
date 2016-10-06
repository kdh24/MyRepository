package com.mycompany.home.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09")
public class Exam09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	private A a;
	private B b;
	private ServiceA serviceA;
	private ServiceB serviceB;
	private ServiceC serviceC;
	
	
	public void setServiceC(ServiceC serviceC) {
		this.serviceC = serviceC;
	}

	public void setServiceB(ServiceB serviceB) {
		this.serviceB = serviceB;
	}

	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public void setB(B b) {
		this.b = b;
	}

	public void setA(A a) {
		this.a = a;
	}

	public Exam09Controller() {
		logger.info("Exam09Controller 객체 생성");
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam09/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		logger.info("method1() 실행");
		a.method();
		b.method();
		serviceA.method();
		serviceB.method();
		serviceC.method();
		return "redirect:/exam09/index";
	}
	
}
