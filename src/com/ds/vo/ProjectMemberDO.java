package com.ds.vo;

import java.sql.Timestamp;

public class ProjectMemberDO {
	
	String id ;
	String password;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProjectMemberDO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public ProjectMemberDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProjectMemberDO [id=" + id + ", password=" + password + "]";
	}
	
	
}
