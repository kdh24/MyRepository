package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam06 {
	public static void main(String[] args) {
		Employee emp = getEmployee(1001);
		System.out.println(emp.getEmpno() + ":" + emp.getEname() + ":" + emp.getSal());

		List<Department> result = getDepartment("개발");
		for (Department dept : result) {
			System.out.println(dept.getDeptno() + ":" + dept.getDname() + ":" + dept.getLoc());
		}
	}

	private static Employee getEmployee(int serchEmpno) {
		// select * from emp where empno=?
		Employee emp = new Employee();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from emp where empno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serchEmpno);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			try { conn.close(); } catch (SQLException e1) { }
			e.printStackTrace();
		}
		return emp;
	}

	private static List<Department> getDepartment(String searchDname) {
		// select * from dept where dname like ?
		List<Department> list = new ArrayList<>();
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");

			String sql = "select * from dept where dname like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchDname + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		}

		return list;
	}
}
