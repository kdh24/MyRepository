package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceB {

	private static final Logger logger = LoggerFactory.getLogger(ServiceB.class);
	
	public ServiceB() {
		System.out.println("ServiceB 생성");
	}
	
	public void method(){
		logger.info("ServiceB method() 실행");
		System.out.println("method() 실행");
	}
}
