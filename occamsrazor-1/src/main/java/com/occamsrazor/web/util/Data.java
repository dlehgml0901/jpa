package com.occamsrazor.web.util;

import java.io.File;

public enum Data {
	ADMINS, USERS, ITEMS;
	
	@Override
	public String toString() {
		String path = "C:"+File.separator+"Users"+File.separator+"user"+File.separator+"git"+File.separator+"repository2"
				+File.separator+"occamsrazor-1"+File.separator+"src"+File.separator+"main"+File.separator+"resources"
				+File.separator+"static"+File.separator+"resources"+File.separator+"file"+File.separator;
		switch (this) {
		case ADMINS: path = path.concat("admins.csv"); break;
		case USERS: path = path.concat("users.csv"); break;
		case ITEMS: path = path.concat("items.csv"); break;
		default:
			break;
		}
		return path;
	}
}
