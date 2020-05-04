package com.occamsrazor.web.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter
public class User {
	private String userid, password, name, ssn, addr, profile, email, phoneNumber, registerDate;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", userid,password,name,ssn, addr,profile, email, phoneNumber, registerDate);
	}
}
