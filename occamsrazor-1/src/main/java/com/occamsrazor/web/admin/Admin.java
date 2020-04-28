package com.occamsrazor.web.admin;

import lombok.Data;

@Data
public class Admin {
	private String employNumber, password, name, 
	position, profile, email, phoneNumber,
	registerDate;
}
