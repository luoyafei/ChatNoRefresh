package com.chat.interfacedao;

import java.util.List;

import com.chat.bean.User;

public interface UserDao {
	public boolean insertUser(User user);
	public boolean deleteUser(Integer userId);
	public boolean updateUser(User user);
	public Integer getAllUsersCount();
	public List<User> getUsers(Integer start, Integer length);
	public User getUserInId(Integer userId);
	public User getUserInName(String userName);
	
	/**
	 * 验证用户名是否存在
	 * @param String userName
	 * @return boolean true:用户名存在，false:用户名不存在
	 * */
	public boolean valdateUserName(String userName);
}
