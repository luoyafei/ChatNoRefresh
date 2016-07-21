package com.chat.bean;

import java.sql.Timestamp;

public class Chat {

	/**
	 * +-------------+----------+------+-----+---------+----------------+
		| Field       | Type     | Null | Key | Default | Extra          |
		+-------------+----------+------+-----+---------+----------------+
		| chatId      | int(11)  | NO   | PRI | NULL    | auto_increment |
		| userId      | int(11)  | YES  |     | NULL    |                |
		| chatContent | text     | NO   |     | NULL    |                |
		| sendDate    | datetime | YES  |     | NULL    |                |
		+-------------+----------+------+-----+---------+----------------+
	 * */
	
	private int chatId = 0;
	private int userId = 0;
	private String chatContent = "";
	private Timestamp sendDate = null;
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	
	public Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	public String getSendDate() {
		if(sendDate == null)
			sendDate = getTimestamp();
		return sendDate.toString();
	}
	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}
	
}
