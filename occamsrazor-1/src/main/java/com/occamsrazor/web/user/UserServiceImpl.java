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

import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	public final static String FILE_PATH = "C:\\Users\\user\\spring-workspace\\occamsrazor\\src\\main\\resources\\static\\user\\";
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
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
	public User detail(String userid) {
		return null;
	}

	@Override
	public boolean update(User user) {
		return true;
	}

	@Override
	public boolean remove(String userid) {
		return true;
	}

	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet(); //entry - 데이터
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator(); //데이터를 정렬한다..
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			list.add(e.getValue()); //키값은 필요없고 value값만 list에 추가해준다.
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
	@Override
	public boolean idSearch(String userid) {
		boolean ok = true;
		List<User> list = list();
		for (int i = 0; i < list.size(); i++) {
			if (userid.equals(list.get(i).getUserid())) {
				ok = false;
				break;
			}
		}
		return ok;
	}
}
