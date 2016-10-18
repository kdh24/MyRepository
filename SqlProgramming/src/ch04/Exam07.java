package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exam07 {
	public static void main(String[] args) {
		List<JobSalary> result = getMethod("사원", 1000);
		for(JobSalary js : result){
			System.out.println(js.getJob() + ":" + js.getSalary());
		}
	}

	private static List<JobSalary> getMethod(String job, int salary) {
		List<JobSalary> list = new ArrayList<>();
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select job, sum(sal) as salary from emp where job<>? group by job having sum(sal)>=? order by salary";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			pstmt.setInt(2, salary);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				JobSalary jobSalary = new JobSalary();
				jobSalary.setJob(rs.getString(1)); //jobSalary.setJob(rs.getString("job"));
				jobSalary.setSalary(rs.getInt(2)); //jobSalary.setSalary(rs.getInt("salary"));
				list.add(jobSalary);
			}
			
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) { }
		}
		return list;
	}
}
