package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(PhotoBoard photoboard){
		String sql = "insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextval, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				photoboard.getBtitle(),
				photoboard.getBcontent(),
				photoboard.getBwriter(),
				photoboard.getOriginalFile(),
				photoboard.getSavedfile(),
				photoboard.getMimetype()
		);
		return row;
	}
	
	public int update(PhotoBoard photoBoard){
		String sql = "update photoboard set btitle=?, bcontent=?, bhitcount=?, originalfile=?, savedfile=?, mimetype=? where bno=?";
		int row = jdbcTemplate.update(
				sql,
				photoBoard.getBtitle(),
				photoBoard.getBcontent(),
				photoBoard.getBhitcount(),
				photoBoard.getOriginalFile(),
				photoBoard.getSavedfile(),
				photoBoard.getMimetype(),
				photoBoard.getBno()
		);
		return row;
	}
	
	public int delete(int bno){
		String sql = "delete from photoboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
	}
	
	public PhotoBoard selectByBno(int bno){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype from photoboard where bno=?";
		/* 무조건 하나의 값이 있어야 함 
		 * jdbcTemplate.queryforObject
		 * 값이 없으면 빈 객체를 준다
		 * jdbcTemplate.query
		 * */
		
		List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[] {bno}, new RowMapper<PhotoBoard>() {

			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				PhotoBoard photoBoard = new PhotoBoard();
				photoBoard.setBno(rs.getInt("bno"));
				photoBoard.setBtitle(rs.getString("btitle"));
				photoBoard.setBcontent(rs.getString("bcontent"));
				photoBoard.setBwriter(rs.getString("bwriter"));
				photoBoard.setBhitcount(rs.getInt("bhitcount"));
				photoBoard.setBdate(rs.getDate("bdate"));
				photoBoard.setOriginalFile(rs.getString("originalfile"));
				photoBoard.setSavedfile("savedfile");
				photoBoard.setMimetype("mimetype");
				
				return photoBoard;
			}
		});
		return (list.size()!=0)? list.get(0) : null;
	}
	
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql = "";
		sql += "select rn bno, btitle, bhitcount, savedfile ";
		sql += "from ( ";
		sql += " select rownum as rn, bno, btitle, bhitcount, savedfile ";
		sql += " from (select btitle, bhitcount, savedfile from photoboard order by bno desc) ";
		sql += " where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<PhotoBoard> list = jdbcTemplate.query(
				sql,
				new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
				new RowMapper<PhotoBoard>(){

					@Override
					public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
						PhotoBoard photoBoard = new PhotoBoard();
						photoBoard.setBno(rs.getInt("bno"));
						photoBoard.setBtitle(rs.getString("btitle"));
						photoBoard.setBhitcount(rs.getInt("bhitcount"));
						photoBoard.setSavedfile(rs.getString("savedfile"));
						
						return photoBoard;
					}
			}
		);	
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from photoboard";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		// sql(count)에서 받은 값을 어떤 타입으로 만들어서 가져올 것이다 (Integer.class)
		return count;
	}
}
