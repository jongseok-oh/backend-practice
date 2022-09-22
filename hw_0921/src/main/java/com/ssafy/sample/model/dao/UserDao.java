package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.ssafy.sample.dto.User;
import com.ssafy.sample.util.DBUtil;

public class UserDao {
	private DBUtil dbUtil = DBUtil.getInstance();
	
	public int insertUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(userId, name, passWord) values(?,?,?)";
		
		int rowCnt;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassWord());
			rowCnt = pstmt.executeUpdate();
			
			return rowCnt;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			dbUtil.close(conn, pstmt);
		}
	}
	
	public User selectUser(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userId, name, passWord from user where userId = ?";
		User user = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbUtil.close(conn, pstmt);
		}
		return user;
	}
	
}
