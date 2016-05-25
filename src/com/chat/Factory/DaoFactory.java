package com.chat.Factory;

import com.chat.dao.ChatMysqlDao;
import com.chat.dao.HeadPictureMysqlDao;
import com.chat.dao.UserMysqlDao;
import com.chat.interfacedao.ChatDao;
import com.chat.interfacedao.HeadPictureDao;
import com.chat.interfacedao.UserDao;

public class DaoFactory {
	public static UserDao createUserDao() {
		return new UserMysqlDao();
	}
	public static ChatDao createChatDao() {
		return new ChatMysqlDao();
	}
	public static HeadPictureDao createHeadPictureDao() {
		return new HeadPictureMysqlDao();
	}
}
