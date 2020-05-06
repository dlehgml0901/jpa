package com.occamsrazor.web.admin;

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

@Repository //저장소
public class AdminDaoImpl implements AdminDao{

	@Override
	public void insert(Admin admin) {
		System.out.println("3 AdminDaoImpl insert" + admin);
		try {
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(
									new File(Data.ADMINS.toString()), true));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
			System.out.println("4 File input success ");
		} catch (Exception e) {
			System.out.println(Messenger.FIlE_INSERT_ERROR);
		}
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> adminlist = new ArrayList();
		List<String> list = new ArrayList();
		try {
			File file = new File(Data.ADMINS.toString());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while ((message = reader.readLine()) != null) {
				list.add(message);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		Admin a = null;
		for (int i = 0; i < list.size(); i++) {
			a = new Admin();
			String[] arr = list.get(i).split(",");
			a.setEmployNumber(arr[0]);
			a.setName(arr[1]);
			a.setPosition(arr[2]);
			a.setEmail(arr[3]);
			a.setPhoneNumber(arr[4]);
			a.setRegisterDate(arr[5]);
			adminlist.add(a);
		}
		return adminlist;
	}

	@Override
	public Admin selectOne(String employNumber) {
		List<Admin> list = selectAll();
		Admin findAdmin = null;
		for (Admin a : list) {
			if (employNumber == a.getEmployNumber()) {
				findAdmin = a;
				break;
			}
		}
		
		return null;
	}

	@Override
	public void update(Admin admin) {
		try {
			
		} catch (Exception e) {
			
		}
	}

	@Override
	public void delete(Admin admin) {
		try {
			
		} catch (Exception e) {
			
		}
	}
	
}
