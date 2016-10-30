package com.home.homeweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.home.homeweb.dto.Member;

@Component
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Member member){
		String sql = "insert into member(mid, mname, mpassword, maddress, mtel, memail) values(?, ?, ?, ?, ?, ?)";
		
		int row = jdbcTemplate.update(
				sql,
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMaddress(),
				member.getMtel(),
				member.getMemail()
		);
		
		return row;
	}
	
	public Member selectByMid(String mid){
		String sql = "select mid, mname, mpassword, maddress, mtel, memail from member where mid=?";
		List<Member> list = jdbcTemplate.query(sql, new Object[]{mid}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMaddress(rs.getString("maddress"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				
				return member;
			}
		});
		return (list.size()!=0)? list.get(0) : null;
	}
}
