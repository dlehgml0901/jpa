package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) {
		System.out.println("3 AdminDaoImpl insert" + user);
		try {
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(
									new File(Data.USERS.toString()), true));
			writer.write(user.toString());
			writer.newLine();
			writer.flush();
			System.out.println("4 File input success ");
		} catch (Exception e) {
			System.out.println(Messenger.FIlE_INSERT_ERROR);
		}
		
	}

	@Override
	public List<User> selectAll() {
		List<User> userlist = new ArrayList();
		List<String> list = new ArrayList();
		try {
			File file = new File(Data.USERS.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine()) != null) {
				list.add(message);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		User u = null;
		for (String s : list) {
			u = new User();
			String[] arr = s.split(",");
			u.setUserid(arr[0]);
			u.setPassword(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddr(arr[4]);
			u.setProfile(arr[5]);
			u.setEmail(arr[6]);
			u.setPhoneNumber(arr[7]);
			u.setRegisterDate(arr[8]);
			userlist.add(u);
		}
		return userlist;
	}

	@Override
	public User selectOne(String userid) {
		List<User> list = selectAll();
		User findUser = null;
		for (User u : list) { //향상된  for문
			if (userid.equals(u.getUserid())) {
				findUser = u;
				break;
			}
		}
		return findUser;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
