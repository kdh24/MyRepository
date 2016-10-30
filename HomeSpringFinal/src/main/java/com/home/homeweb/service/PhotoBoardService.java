package com.home.homeweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.homeweb.dao.PhotoBoardDao;
import com.home.homeweb.dto.PhotoBoard;

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
		return photoBoardDao.selecByPage(pageNo, rowsPerPage);
	}
	public int write(PhotoBoard photoBoard){
		int row = photoBoardDao.insert(photoBoard);
		return WRITE_SUCCESS;
	}
	public int modify(PhotoBoard photoBoard){
		int row = photoBoardDao.update(photoBoard);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int bno){
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
