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
	
	private Integer chatId = 0;
	private Integer userId = 0;
	private String chatContent = "";
	private Timestamp sendDate = null;
	public Integer getChatId() {
		return chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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
