package com.mycompany.home.exam06;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request) {
		logger.info("method1 요청 처리");
		logger.info("WebClient IP: " + request.getRemoteAddr());
		logger.info("WebClient 종류: " + request.getHeader("User-Agent"));
		if(request.getHeader("User-Agent").contains("Chrome")){
			logger.info("브라우저 종류: 크롬");
		}else if(request.getHeader("User-Agent").contains("Trident/7.0")){
			logger.info("브라우저 종류: 인터넷 익스풀로러 11");
		}else if(request.getHeader("User-Agent").contains("MSIE")){
			logger.info("브라우저 종류: 인터넷 익스풀로러 10이하");
		}
		//요청 파라미터 값 얻기
		logger.info("mid: " + request.getParameter("mid"));
		logger.info("mname: " + request.getParameter("mname"));
		//쿼리 문자열 얻기
		logger.info("쿼리 문자열: " + request.getQueryString());
		logger.info("요청 URI: " + request.getRequestURI());
		logger.info("요청 URL: " + request.getRequestURL());
		logger.info("요청 방식: " + request.getMethod());
		logger.info("시스템 파일 경로: " + request.getServletContext().getRealPath("/WEB-INF/image/join.jpg"));
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4CreateCookie")
	public String method4CreateCookie(HttpServletResponse response) throws UnsupportedEncodingException{
		Cookie cookie1 = new Cookie("mid", "fall");
		String name = "홍길동";
		name = URLEncoder.encode(name, "UTF-8");
		Cookie cookie2 = new Cookie("mname", name);
		cookie2.setMaxAge(60);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow1")
	public String method4ReceiveCookieHow1(HttpServletRequest request) throws UnsupportedEncodingException{
		//쿠키 받기 - 요청 헤더의 쿠키 정보를 읽기
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = null;
				if (cookie.getName().equals("mname")) {
					value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				} else {
					value = cookie.getValue();
				}

				System.out.println(name + ":" + value);
			}
		}

		return "exam06/index";
	}
	
	@RequestMapping("/method4ReceiveCookieHow2")
	public String method4ReceiveCookieHow2(@CookieValue(defaultValue="") String mid, @CookieValue(defaultValue="") String mname){
		System.out.println("mid: " + mid);
		System.out.println("mname: " + mname);
		logger.info("how2 요청 처리");
		return "exam06/index";
	}

	@RequestMapping("/method4DeleteCookie")
	public String method4DeleteCookie(HttpServletResponse response){
		Cookie cookie1 = new Cookie("mid", "");
		cookie1.setMaxAge(0);
		
		Cookie cookie2 = new Cookie("mname", "");
		cookie1.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5SetObject")
	public String method5SetObject(HttpSession session){
		Member member = new Member("fall", "한가을");
		
		session.setAttribute("member", member);
		
		return "exam06/index";
	}
	
	@RequestMapping("/method5GetObject")
	public String method5GetObject(HttpSession session){
		Member member = (Member) session.getAttribute("member");
		
		
		return "exam06/index";
	}
}
