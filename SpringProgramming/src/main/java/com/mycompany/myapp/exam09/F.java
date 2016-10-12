package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class F {
	private static final Logger logger = LoggerFactory.getLogger(F.class);
	
	private ServiceA sa;
	private ServiceB sb;
	private ServiceC sc;
	
	
	public F(ServiceA sa, ServiceB sb, ServiceC sc) {
		logger.info("F 객체 생성");
		this.sa = sa;
		this.sb = sb;
		this.sc = sc;
	}
	
	public void method(){
		logger.info("method 실행");
		sa.method();
		sb.method();
		sc.method();
	}
}
