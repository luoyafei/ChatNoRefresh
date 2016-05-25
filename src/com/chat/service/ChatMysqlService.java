package com.chat.service;

import java.util.List;

import com.chat.Factory.DaoFactory;
import com.chat.bean.Chat;
import com.chat.interfacedao.ChatDao;
import com.chat.interfaceservice.ChatService;

public class ChatMysqlService implements ChatService {

	private ChatDao cmd = null;
	public ChatMysqlService() {
		cmd = DaoFactory.createChatDao();
	}
	
	@Override
	public boolean insertChat(Chat chat) {
		// TODO Auto-generated method stub
		return cmd.insertChat(chat);
	}

	@Override
	public boolean deleteChat(Integer chatId) {
		// TODO Auto-generated method stub
		return cmd.deleteChat(chatId);
	}

	@Override
	public Integer getAllChatCountInUser(Integer userId) {
		// TODO Auto-generated method stub
		return cmd.getAllChatCountInUser(userId);
	}

	@Override
	public Integer getAllChatCounts() {
		// TODO Auto-generated method stub
		return cmd.getAllChatCounts();
	}

	@Override
	public List<Chat> getAllChats(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return cmd.getAllChats(start, length);
	}

	@Override
	public List<Chat> getHundChatInfo(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return cmd.getHundChatInfo(start, length);
	}

}
