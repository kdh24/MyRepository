package com.mycompany.home.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImpl2 implements ServiceD{
	private static final Logger logger = LoggerFactory.getLogger(ServiceDImpl2.class);
	
	@Override
	public void method() {
		logger.info("method 실행");
	}

}
