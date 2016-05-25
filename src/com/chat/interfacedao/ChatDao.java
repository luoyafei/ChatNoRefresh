package com.chat.interfacedao;

import java.util.List;

import com.chat.bean.Chat;

public interface ChatDao {
	public boolean insertChat(Chat chat);
	public boolean deleteChat(Integer chatId);
	/**
	 * 通过ChatId删除消息
	 * @param Integer userId
	 * @return Integer
	 * */
	public Integer getAllChatCountInUser(Integer userId);
	/**
	 * 获取所有的消息数
	 * */
	public Integer getAllChatCounts();
	public List<Chat> getAllChats(Integer start, Integer length);
	/**
	 * 获取最近的一百条消息
	 * @param Integer start and Integer length=100
	 * @return List<Chat>
	 * */
	public List<Chat> getHundChatInfo(Integer start, Integer length);
}
