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
	 * ͨ���û�������֤���û��Ƿ������ݿ��д���
	 * @param String userName �����û���
	 * @return boolean true:���ڣ�false:�����ڣ�
	 * */
	public boolean valdateUserName(String userName);
}
