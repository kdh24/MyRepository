package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");//JDBC 드라이버 불러오기
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		//DB 마다 연결이 다 다르다  5가지 정보중  3가지 , 이름, 패스워드
		/*Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);
		Connection conn = DriverManager.getConnection("jdbc:oravle:thin:@localhost:1521:orcl", "tester1", "kosa12345");*/
		
		//매개변수화된 SQL문
		String sql = "select ename, empno, sal from emp where ename like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%성%"); 	// 문자열 일부만 넣을 수 없다  , 주의
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			int empno = rs.getInt(2);
			String ename = rs.getString("ename");
			int sal = rs.getInt("sal");
			System.out.println(empno + ":" + ename + ":" + sal);
		}
		
		rs.close();
		pstmt.close();
		conn.close();	// 다 쓰면 연결을 꼭 끊어줘야 함
		
	}
}
