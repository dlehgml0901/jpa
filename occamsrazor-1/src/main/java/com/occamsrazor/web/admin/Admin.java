package com.occamsrazor.web.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Admin {
	private String employNumber, password, name, 
	position, profile, email, phoneNumber,
	registerDate;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s", 
				employNumber,password,name,position,profile,email,phoneNumber,registerDate);
	}
}
