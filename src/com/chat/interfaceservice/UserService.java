package com.chat.interfaceservice;

import java.util.List;

import com.chat.bean.User;

public interface UserService {
	public boolean insertUser(User user);
	public boolean deleteUser(Integer userId);
	public boolean updateUser(User user);
	public Integer getAllUsersCount();
	public List<User> getUsers(Integer start, Integer length);
	public User getUserInId(Integer userId);
	public User getUserInName(String userName);
	
	/**
	 * 通过用户名来验证该用户是否在数据库中存在
	 * @param String userName 输入用户名
	 * @return boolean true:存在；false:不存在；
	 * */
	public boolean valdateUserName(String userName);
}
