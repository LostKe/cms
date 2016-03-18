package com.cms.bean;

public class User {
	private String userName;
	private int age;
	private String addr;

	public User(String userName, int age, String addr) {
		super();
		this.userName = userName;
		this.age = age;
		this.addr = addr;
	}

	
	public User() {
		super();
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
