package com.occamsrazor.web.item;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Repository
public class ItemDaoImpl implements ItemDao{

	@Override
	public List<Item> selectAll() {
		List<Item> items = new ArrayList();
		List<String> list = new ArrayList();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(Data.ITEMS.toString())));
			String message = "";
			while ((message = reader.readLine()) != null) {
				list.add(message);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
			e.printStackTrace();
		}
		Item item = null;
		for (String s : list) {
			item = new Item();
			String[] arr = s.split(",");
			item.setItemId(arr[0]);
			item.setItemName(arr[1]);
			item.setTakerDate(arr[2]);
			item.setCategory(arr[3]);
			item.setTakenPostion(arr[4]);
			items.add(item);
		}
		return items;
	}

}
