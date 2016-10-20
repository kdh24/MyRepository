package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import finalsource.dao.BoardDao;
import finalsource.dto.Board;

public class TestBoardDao {
	public static void main(String[] args) {
		testInsert();
//		testSelectByBno();
//		testSelectByBtitle();
//		testUpdate();
//		testDeleteByBno();
	}

	public static void testInsert() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");

			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			Board board =null;// new Board();

//			board.setBno(1);
			board.setBtitle("제목1");
			board.setBcontent("내용1");
			board.setBwriter("user7");
			board.setBhitcount(0);
			board.setBdate(new Date());
			int rowNo = dao.insert(board);
			/*int rowNo= 0;
			for(int i=1; i<10000; i++){
				board = new Board();
				board.setBtitle("제목" + i);
				board.setBcontent("내용" + i);
				board.setBwriter("user7");
				board.setBhitcount(0);
				board.setBdate(new Date());
				rowNo += dao.insert(board);
			}
			*/
			System.out.println(rowNo + "행 추가됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void testSelectByBno() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");

			BoardDao dao = new BoardDao();
			dao.setConn(conn);

			Board board = dao.selectByBno(1);
			System.out.print(board.getBno() + ":");
			System.out.print(board.getBtitle() + ":");
			System.out.print(board.getBcontent() + ":");
			System.out.print(board.getBwriter() + ":");
			System.out.print(board.getBhitcount() + ":");
			System.out.print(board.getBdate());
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void testSelectByBtitle(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			List<Board> list = dao.selectByBtitle("제목");
			
			for(Board board : list){
				System.out.print(board.getBno() + ":");
				System.out.print(board.getBtitle() + ":");
				System.out.print(board.getBcontent() + ":");
				System.out.print(board.getBwriter() + ":");
				System.out.print(board.getBhitcount() + ":");
				System.out.print(board.getBdate());
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {}
		}
	}

	public static void testUpdate() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);

			Board board = new Board();
			board.setBno(1);
			board.setBtitle("제목수정1");
			board.setBcontent("내용수정1");
			board.setBwriter("user10");
			board.setBhitcount(10);
			board.setBdate(new Date());
			
			int rawNo = dao.update(board);
			System.out.println(rawNo +"행 수정됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {}
		}
	}

	public static void testDeleteByBno() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			
			BoardDao dao = new BoardDao();
			dao.setConn(conn);
			
			int rawNo = dao.deleteByBno(1);
			System.out.println(rawNo + "행 삭제됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {}
		}

	}
}
