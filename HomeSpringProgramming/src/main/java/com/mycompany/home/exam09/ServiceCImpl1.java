package com.mycompany.home.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceCImpl1 implements ServiceC{
	private static final Logger logger = LoggerFactory.getLogger(ServiceCImpl1.class);
	
	public ServiceCImpl1() {
		logger.info("ServiceCImpl1 생성");
	}
	
	@Override
	public void method() {
		logger.info("ServiceCImpl1 method 처리");
	}
	

}
