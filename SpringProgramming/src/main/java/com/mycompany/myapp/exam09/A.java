package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.myapp.exam08.Exam08Controller;

public class A {
	private static final Logger logger = LoggerFactory.getLogger(A.class);

	public A() {
		logger.info("A객체 생성");
	}
	
	public void method() {
		logger.info("method 실행");
	}
}
