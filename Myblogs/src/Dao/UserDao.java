package Dao;

import java.util.List;

import po.User;

public interface UserDao {
	public User getUser(User user);
	public User findUser(User user);
	public int addUser(User user);
	public List<User> getUsers();
	public void setUser(User user);
	public int delUser(String id);
	
	
	public List<User> findUsers_id(User user);
	public List<User> findUsers_name(User user);
	
}
