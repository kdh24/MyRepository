package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam04 {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		Board board = new Board();
		
		board.setBno(5);
		board.setBtitle("제목5");
		board.setBcontent("내용5");
		board.setBhitcount(0);
		board.setBwriter("글쓴이5");
		board.setBdate(new Date());
		
		dao.insert(board);
	}
	
}
