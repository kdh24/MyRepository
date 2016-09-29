package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet{
	//필드
	private String location;
	
	//생성자
	public NowServlet(){
		System.out.println("NowServlet 객체 생성");
	}
	
	//초기화 메소드
	@Override
	public void init(ServletConfig config) throws ServletException {	//web.xml의 <init-param>의 값을 받기 위한 메소드
		System.out.println("NowServlet 객체 초기화");
		location = config.getInitParameter("location");
	}
	
	//메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");	// response 객체에서 응답 http의 Content-Type과 charset을 설정한다.
																// 띄어 쓰기 ;뒤에는 해도 되고 안해도 되지만 나머지는 절대 하면 안된다!!!!!!
//		response.setHeader(name, value); // 헤드에 더 내용을 추가하고 싶을 때 사용 setContentType이 그만큼 중요하기에 별도 제공한다

		//OutputStream os = response.getOutputStream();	//문자 및 다른 여러 데이터를 보낼 때
		PrintWriter out = response.getWriter();	// 출력 메소드를 사용하기 위함	// 문자만 보낼 때
		
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'></head>");
		out.println("<body>");
		out.println("현재 "+ location + " 시간 : "+ new Date().toString());
		out.println("</body>");
		out.println("</html>");
	}
}
