package com.occamsrazor.web.admin;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Component
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
