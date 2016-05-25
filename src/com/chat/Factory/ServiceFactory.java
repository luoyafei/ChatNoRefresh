package com.chat.Factory;

import com.chat.interfaceservice.ChatService;
import com.chat.interfaceservice.HeadPictureService;
import com.chat.interfaceservice.UserService;
import com.chat.service.ChatMysqlService;
import com.chat.service.HeadPictureMysqlService;
import com.chat.service.UserMysqlService;

public class ServiceFactory {

	public static UserService createUserService() {
		return new UserMysqlService();
	}
	public static ChatService createChatService() {
		return new ChatMysqlService();
	}
	public static HeadPictureService createHeadPictureService() {
		return new HeadPictureMysqlService();
	}
}
