package com.chat.bean;

public class User {

	/*
	 *mysql> desc user;
	+-------------+--------------+------+-----+---------+----------------+
	| Field       | Type         | Null | Key | Default | Extra          |
	+-------------+--------------+------+-----+---------+----------------+
	| userId      | int(11)      | NO   | PRI | NULL    | auto_increment |
	| userName    | varchar(255) | NO   |     | NULL    |                |
	| password    | varchar(255) | NO   |     | NULL    |                |
	| readCount   | int(11)      | YES  |     | NULL    |                |
	| userPicture | varchar(255) | YES  |     | NULL    |                |
	+-------------+--------------+------+-----+---------+----------------+
	 * 
	 * */
	
	private Integer userId = 0;
	private String userName = "";
	private String password = "";
	private Integer readCount = 0;
	private String userPicture = "/ChatNoRefresh/assets/img/moren.jpg";
	public String getUserPicture() {
		return userPicture;
	}
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	
}
