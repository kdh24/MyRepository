package com.mycompany.home.exam11.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.home.exam11.dao.Exam11BoardDao;
import com.mycompany.home.exam11.dto.Board;

@Component
public class Exam11BoardService {
	private static final Logger logger = LoggerFactory.getLogger(Exam11BoardService.class);
	
	@Autowired
	Exam11BoardDao boardDao;
	
	public void write(Board board){
		logger.info("write 처리");
		boardDao.insert(board);
	}

	public List<Board> getList() {
		logger.info("getlist 처리");
		List<Board> list = boardDao.selectList();
		return list;
	}

	public Board getBoard(int bno) {
		logger.info("getboard 처리");
		Board board = boardDao.selectBoard(bno);
		return board;
	}
	
	
}