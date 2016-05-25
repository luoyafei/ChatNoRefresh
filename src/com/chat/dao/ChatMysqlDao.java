package com.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chat.bean.Chat;
import com.chat.db.ConnectionFactory;
import com.chat.interfacedao.ChatDao;

public class ChatMysqlDao implements ChatDao {

	@Override
	public boolean insertChat(Chat chat) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into chat values(null, ?, ?, now())";
		/**
		 * mysql> desc chat;
			+-------------+----------+------+-----+---------+----------------+
			| Field       | Type     | Null | Key | Default | Extra          |
			+-------------+----------+------+-----+---------+----------------+
			| chatId      | int(11)  | NO   | PRI | NULL    | auto_increment |
			| userId      | int(11)  | YES  |     | NULL    |                |
			| chatContent | text     | NO   |     | NULL    |                |
			| sendDate    | datetime | YES  |     | NULL    |                |
			+-------------+----------+------+-----+---------+----------------+
		 * */
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chat.getUserId());
			pstmt.setString(2, chat.getChatContent());
			if(pstmt.executeUpdate() >= 1)
				flag = true;
		} catch(SQLException e) {
			flag = false;
System.out.println("插入消息出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedConn(conn);
			ConnectionFactory.closedPstmt(pstmt);
		}
		return flag;
	}

	@Override
	public boolean deleteChat(Integer chatId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getAllChatCountInUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chat> getAllChats(Integer start, Integer length) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from chat order by chatId desc limit ?,?";
		List<Chat> chats = new ArrayList<Chat>();
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, length);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Chat chat = new Chat();
				chat.setChatId(rs.getInt("chatId"));
				chat.setUserId(rs.getInt("userId"));
				chat.setChatContent(rs.getString("chatContent"));
				chat.setSendDate(rs.getTimestamp("sendDate"));
				chats.add(chat);
			}
		} catch (SQLException e) {
System.out.println("获取未读消息出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedCPR(conn, pstmt, rs);
		}
		return chats;
		/**
		 * mysql> desc chat;
			+-------------+----------+------+-----+---------+----------------+
			| Field       | Type     | Null | Key | Default | Extra          |
			+-------------+----------+------+-----+---------+----------------+
			| chatId      | int(11)  | NO   | PRI | NULL    | auto_increment |
			| userId      | int(11)  | YES  |     | NULL    |                |
			| chatContent | text     | NO   |     | NULL    |                |
			| sendDate    | datetime | YES  |     | NULL    |                |
			+-------------+----------+------+-----+---------+----------------+
		 * */
	}

	@Override
	public Integer getAllChatCounts() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select count(*) from chat";
		Statement stmt = null;
		ResultSet rs = null;
		Integer count = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
		} catch(SQLException e) {
System.out.println("获取所有消息个数出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedCSR(conn, stmt, rs);
		}
		return count;
	}

	@Override
	public List<Chat> getHundChatInfo(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return null;
	}

}
