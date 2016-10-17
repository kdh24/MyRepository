package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("검색할 이름: ");
			String name = sc.nextLine();
			List<Employee> result = getList(name);
			for(Employee emp : result){
				System.out.println(emp.getEmpno() + ":" + emp.getEname());
			}
		}
	}
	
	//db에서 끌어온 데이터를 어떤식으로 넘겨주는가
	// 데이터를 table 형식으로 가져온다 -> ResultSet    자바객체에 ResultSet을 어떻게 전달할 것인가
	
	public static List<Employee> getList(String searchName){
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		try {
//			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from emp where ename like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + searchName + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
//				int id = rs.getInt("employee_id");			// String employee_id = rs.getString(1);
//				String fname = rs.getString("first_name");	// String first_name = rs.getString(2);
//				System.out.println(id + ":" + fname);		// System.out.println(employee_id + ":" + first_name);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e2) {}
			e.printStackTrace();
		}
		return list;
	}
}
