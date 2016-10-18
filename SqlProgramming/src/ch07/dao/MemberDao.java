package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Member;

public class MemberDao {
	public Member selectByMid(String mid){
		Member member = null;
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "";
			sql += "select * from Member where lower(mid) like lower(?) ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + mid + "%");
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMage(rs.getInt("mage"));
				member.setMbirth(rs.getDate("mbirth"));
				
			}
			
			rs.close();
			pstmt.close();
					
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) { }
		}
		
		return member;
	}
	
	public List<Member> selectAll(){
		List<Member> list = new ArrayList<>();
		Connection conn = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from Member";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMage(rs.getInt("mage"));
				member.setMbirth(rs.getDate("mbirth"));
				list.add(member);
			}

			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) {}
		}
		
		return list;
	}
}
