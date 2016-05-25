package com.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.chat.bean.User;
import com.chat.db.ConnectionFactory;
import com.chat.interfacedao.UserDao;

public class UserMysqlDao implements UserDao {

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(userId, userName, password, readCount, userPicture) values(null, ?, ?, 0, ?)";
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getUserPicture());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
		} catch(SQLException e) {
			flag = false;
System.out.println("插入用户信息出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedConn(conn);
			ConnectionFactory.closedPstmt(pstmt);
		}
		
		return flag;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		/**
		mysql> desc user;
		+-------------+--------------+------+-----+---------+----------------+
		| Field       | Type         | Null | Key | Default | Extra          |
		+-------------+--------------+------+-----+---------+----------------+
		| userId      | int(11)      | NO   | PRI | NULL    | auto_increment |
		| userName    | varchar(255) | NO   |     | NULL    |                |
		| password    | varchar(255) | NO   |     | NULL    |                |
		| readCount   | int(11)      | YES  |     | NULL    |                |
		| userPicture | varchar(255) | YES  |     | NULL    |                |
		+-------------+--------------+------+-----+---------+----------------+
		 * */
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update user set userName=?,password=?,readCount=?,userPicture=? where userId=?";
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getReadCount());
			pstmt.setString(4, user.getUserPicture());
			pstmt.setInt(5, user.getUserId());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
		} catch(SQLException e) {
			flag = false;
System.out.println("更新用户信息出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedConn(conn);
			ConnectionFactory.closedPstmt(pstmt);
		}
		return flag;
	}

	@Override
	public Integer getAllUsersCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserInId(Integer userId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where userId = ?";
		User user = null;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setReadCount(rs.getInt("readCount"));
				user.setUserPicture(rs.getString("userPicture"));
			}
		} catch(SQLException e) {
System.out.println("ͨ通过用户Id获取用户资料出错");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedCPR(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public User getUserInName(String userName) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where userName = ?";
		User user = null;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setReadCount(rs.getInt("readCount"));
				user.setUserPicture(rs.getString("userPicture"));
			}
		} catch(SQLException e) {
System.out.println("通过用户名获取用户资料出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedCPR(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public boolean valdateUserName(String userName) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userName from user where userName = ?";
		User user = null;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				flag = true;
			else
				flag = false;
			
		} catch(SQLException e) {
			flag = false;
System.out.println("ͨ验证用户名出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedCPR(conn, pstmt, rs);
		}
		return flag;
	}
	
}
