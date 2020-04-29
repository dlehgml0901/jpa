package com.occamsrazor.web.user;

import java.util.List;

public interface UserService {

	public void signup(User user);

	public List<User> findAll();

	public User findOne(String userid);

	public void modify(User user);

	public void remove(User user);

	public int count();

	public User login(User user);

	public boolean idSearch(String userid);
}
