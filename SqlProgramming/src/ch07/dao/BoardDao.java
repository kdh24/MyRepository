package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Board;

public class BoardDao {
	public Board selectByBno(int bno){
		Board board = null;
		Connection conn = null; 
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from Board where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBdate(rs.getDate("bdate"));
			}
			
			rs.close();
			pstmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) { }
		}
		
		return board;
	}

	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "";
			sql += "select * from Board ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBdate(rs.getDate("bdate"));
				list.add(board);
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
