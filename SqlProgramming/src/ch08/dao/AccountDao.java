package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public int update(Account account) throws SQLException{
		String sql = "update account set abalance=? where ano=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		int rowNo = pstmt.executeUpdate();
		return rowNo;
	}
}
