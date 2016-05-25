package com.chat.interfaceservice;

import java.util.List;

import com.chat.bean.Chat;

public interface ChatService {
	
	public boolean insertChat(Chat chat);
	public boolean deleteChat(Integer chatId);
	/**
	 * 删除聊天消息
	 * @param Integer userId
	 * @return Integer
	 * */
	public Integer getAllChatCountInUser(Integer userId);
	public Integer getAllChatCounts();
	public List<Chat> getAllChats(Integer start, Integer length);
	/**
	 * 获取最近的一百条聊天消息
	 * @param Integer start and Integer length=100
	 * @return List<Chat>
	 * */
	public List<Chat> getHundChatInfo(Integer start, Integer length);
}
