package com.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chat.bean.Chat;
import com.chat.bean.HeadPicture;
import com.chat.db.ConnectionFactory;
import com.chat.interfacedao.HeadPictureDao;

public class HeadPictureMysqlDao implements HeadPictureDao {

	@Override
	public boolean insertHeadPicture(HeadPicture picture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHeadPicture(HeadPicture picture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHeadPicture(Integer pictureId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HeadPicture getHeadPictureInId(Integer pictureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HeadPicture> getAllHeadPicture() {
		// TODO Auto-generated method stub
		/**
		 * mysql> desc headPicture;
			+------------+--------------+------+-----+---------+----------------+
			| Field      | Type         | Null | Key | Default | Extra          |
			+------------+--------------+------+-----+---------+----------------+
			| pictureId  | int(11)      | NO   | PRI | NULL    | auto_increment |
			| pictureURL | varchar(255) | NO   |     | NULL    |                |
			| useCount   | int(11)      | YES  |     | NULL    |                |
			+------------+--------------+------+-----+---------+----------------+
		 * 
		 * */
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from headPicture";
		List<HeadPicture> pictures = new ArrayList<HeadPicture>();
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HeadPicture picture = new HeadPicture();
				picture.setPictureId(rs.getInt("pictureId"));
				picture.setPictureURL(rs.getString("pictureURL"));
				picture.setUseCount(rs.getInt("useCount"));
				pictures.add(picture);
			}
		} catch (SQLException e) {
System.out.println("获取头像出错！");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closedCPR(conn, pstmt, rs);
		}
		return pictures;
	}

}
