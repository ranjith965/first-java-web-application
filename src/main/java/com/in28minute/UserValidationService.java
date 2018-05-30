package com.in28minute;

public class UserValidationService {

	public boolean isUserValid(String user,String password) {
		if(user.equals("ranjith") && password.equals("password")) {
			return true;
		}
		return false;
	}
}
