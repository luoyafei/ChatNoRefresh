package com.chat.service;

import java.util.List;

import com.chat.bean.User;
import com.chat.dao.UserMysqlDao;
import com.chat.interfaceservice.UserService;

public class UserMysqlService implements UserService {
	private UserMysqlDao umd = null;
	public UserMysqlService() {
		umd = new UserMysqlDao();
	}
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return umd.insertUser(user);
	}
	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return umd.deleteUser(userId);
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return umd.updateUser(user);
	}
	@Override
	public Integer getAllUsersCount() {
		// TODO Auto-generated method stub
		return umd.getAllUsersCount();
	}
	@Override
	public List<User> getUsers(Integer start, Integer length) {
		// TODO Auto-generated method stub
		return umd.getUsers(start, length);
	}
	@Override
	public User getUserInId(Integer userId) {
		// TODO Auto-generated method stub
		return umd.getUserInId(userId);
	}
	@Override
	public User getUserInName(String userName) {
		// TODO Auto-generated method stub
		return umd.getUserInName(userName);
	}
	@Override
	public boolean valdateUserName(String userName) {
		// TODO Auto-generated method stub
		return umd.valdateUserName(userName);
	}
	
}
