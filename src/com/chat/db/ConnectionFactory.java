package com.chat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	private final static String className = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/chatNoRefresh?user=root&password=root";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closedCPR(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	public static void closedCSR(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void closedConn(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closedPstmt(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
