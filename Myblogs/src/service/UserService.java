package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.User;
import Dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUser(User user)
	{
		return userDao.getUser(user);
	}
	
	public User findUser(User user)
	{
		return userDao.findUser(user);
	}
	
	public int addUser(User user)
	{
		return userDao.addUser(user);
	}
	
	public List<User> getUsers()
	{
		return userDao.getUsers();
	}
	
	public void setUser(User user)
	{
		userDao.setUser(user);
	}
	public int delUser(String id)
	{
		return userDao.delUser(id);
	}

	
	public List<User> findUsers_id(User user)
	{
		return userDao.findUsers_id(user);
	}
	public List<User> findUsers_name(User user)
	{
		return userDao.findUsers_name(user);
	}
}
