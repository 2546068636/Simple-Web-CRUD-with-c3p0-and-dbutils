package com.user.bean;

public class Bean {
	private String name;
	private String id;
	private String sex;
	
	public Bean(String name, String id, String sex) {
		super();
		this.name = name;
		this.id = id;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Bean() {
		// TODO Auto-generated constructor stub
	}

}
