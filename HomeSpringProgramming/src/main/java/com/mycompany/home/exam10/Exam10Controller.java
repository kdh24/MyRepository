package com.mycompany.home.exam10;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam10")
public class Exam10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam10Controller.class);
	
	private G g;
	@Autowired
	public void setG(G g){
		this.g = g;
	}
	
	private H h;
	@Autowired
	public void setH(H h){
		this. h = h;
	}
	
	private I i;
	@Autowired
	public void setI(I i){
		logger.info("setI 처리");
		this.i = i;
	}
	
	private J j;
	@Autowired
	public void setJ(J j){
		logger.info("setJ 처리");
		this.j = j;
	}

	@Autowired
	private K k;
	private Service service;

	@Resource(name="serviceImpl1")
	public void setService(Service service){
		this.service = service;
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam10/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		logger.info("method1 처리");
		g.method();
		h.method();
		service.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method2")
	public String method2(){
		logger.info("method2 처리");
		i.method();
		j.method();
		return "redirect:/exam10/index";
	}
	
	@RequestMapping("/method3")
	public String method3(){
		logger.info("method3 처리");
		k.method();
		return "redirect:/exam10/index";
	}
	
}
