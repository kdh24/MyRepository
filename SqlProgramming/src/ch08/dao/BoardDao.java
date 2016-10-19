package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Board;

public class BoardDao {
	public void insert(Board board){
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			pstmt.setInt(5, board.getBhitcount());
			pstmt.setDate(6, new Date(board.getBdate().getTime()));
			int rawNo = pstmt.executeUpdate();
			
			if(rawNo == 1){
				System.out.println("추가 성공");
			}
			
			pstmt.close();
		}catch(Exception e){
			System.out.println("추가 실패");
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) { }
		}
	}

	public void update(Board board) {
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			String sql = "update board set btitle=?, bcontent=?, bdate=? where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setDate(3, new Date(board.getBdate().getTime()));
			pstmt.setInt(4, board.getBno());
			int rawNo = pstmt.executeUpdate();
			
			if(rawNo >= 1){
				System.out.println(rawNo +"행이 수정됨");
			}else if(rawNo ==0){
				System.out.println("수정된 행이 없음");
			}
			
			pstmt.close();
		}catch(Exception e){
			System.out.println("수정 실패");
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) { }
		}
	}
	
	public void deleteByBtitle(String btitle){
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			String sql = "delete board where btitle like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + btitle + "%");
			int rawNo = pstmt.executeUpdate();
			
			if(rawNo >= 1){
				System.out.println(rawNo +"행이 삭제됨");
			}else if(rawNo ==0){
				System.out.println("삭제된 행이 없음");
			}
			
			pstmt.close();
		}catch(Exception e){
			System.out.println("삭제 실패");
			e.printStackTrace();
		}finally{
			try { conn.close(); } catch (SQLException e) { }
		}
	}
}
