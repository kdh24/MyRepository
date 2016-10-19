package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam06 {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		dao.deleteByBtitle("제목1");
	}
	
}
