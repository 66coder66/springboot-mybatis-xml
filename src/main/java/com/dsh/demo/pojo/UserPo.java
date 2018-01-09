package com.dsh.demo.pojo;

import java.io.Serializable;

public class UserPo implements Serializable{
	
	private static final long serialVersionUID = 7500119189199787048L;
	private Integer user_id;
	private String user_name;
	private String type;
	private String browse_ip;
	
	public UserPo() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrowse_ip() {
		return browse_ip;
	}

	public void setBrowse_ip(String browse_ip) {
		this.browse_ip = browse_ip;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		// TODO
		return "userName: " + this.user_name + ", type: " + this.type + " Browse_ip: " + this.browse_ip;
	}
}
