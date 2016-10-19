package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam05 {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		Board board = new Board();
		
		board.setBno(5);
		board.setBtitle("제목5수정");
		board.setBcontent("내용5수정");
		board.setBdate(new Date(1985, 10, 8));
		
		dao.update(board);
	}
	
}
