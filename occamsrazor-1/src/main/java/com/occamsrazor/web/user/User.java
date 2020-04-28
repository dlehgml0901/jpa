package com.occamsrazor.web.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data @Getter @Setter
public class User {
	private String name, userid, password, ssn, addr, profile, email, registerDate;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", userid,password,name,ssn,addr);
	}
}
