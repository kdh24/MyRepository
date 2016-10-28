package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.PhotoBoardDao;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardService {
	public static final int WRITE_SUCCESS=0;
	public static final int WRITE_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int REMOVE_SUCCESS=0;
	public static final int REMOVE_FAIL=1;
	
	@Autowired
	private PhotoBoardDao photoBoardDao;
	
	public List<PhotoBoard> list(int pageNo, int rowsPerPage){
		return photoBoardDao.selectByPage(pageNo, rowsPerPage);
	}
	public int write(PhotoBoard photoBoard){
		int row = photoBoardDao.insert(photoBoard);
//		if(row != 1){ return WRITE_FAIL; }
		return WRITE_SUCCESS;
	}
	public int modify(PhotoBoard photoboard) {
		int row = photoBoardDao.update(photoboard);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	public int remove(int bno) {
		int row = photoBoardDao.delete(bno);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public PhotoBoard info(int bno) {
		return photoBoardDao.selectByBno(bno);
	}
	public int getCount(){
		return photoBoardDao.count();
	}
}