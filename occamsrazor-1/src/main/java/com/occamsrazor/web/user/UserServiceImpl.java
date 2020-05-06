package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDao userDao;
	
	@Override
	public void signup(User user) {
		try {
			File file = new File(Data.USERS.toString());
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					String message = user.toString();
					writer.write(message);
					writer.newLine();
					writer.flush();
		} catch(Exception e) {
			System.out.println(Messenger.FIlE_INSERT_ERROR);
		}
		userDao.insert(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.selectAll();
	}

	@Override
	public User findOne(String userid) {
		return userDao.selectOne(userid);
	}

	@Override
	public void modify(User user) {
		userDao.update(user);
	}

	@Override
	public void remove(User user) {
		userDao.delete(user);
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		
		return returnUser;
	}

	@Override
	public boolean idSearch(String userid) {
		boolean ok = true;
		List<User> list = findAll();
		for (int i = 0; i < list.size(); i++) {
			if (userid.equals(list.get(i).getUserid())) {
				ok = false;
				break;
			}
		}
		return ok;
	}

	
}
