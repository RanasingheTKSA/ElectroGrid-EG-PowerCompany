package com.electrogrid.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private int id;
	private String user_name;
	private String user_nic;
	private String user_address;
	private String user_zip_code;
	private String user_contact_number;
	private String user_email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nic() {
		return user_nic;
	}
	public void setUser_nic(String user_nic) {
		this.user_nic = user_nic;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_zip_code() {
		return user_zip_code;
	}
	public void setUser_zip_code(String user_zip_code) {
		this.user_zip_code = user_zip_code;
	}
	public String getUser_contact_number() {
		return user_contact_number;
	}
	public void setUser_contact_number(String user_contact_number) {
		this.user_contact_number = user_contact_number;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", user_nic=" + user_nic + ", user_address="
				+ user_address + ", user_zip_code=" + user_zip_code + ", user_contact_number=" + user_contact_number
				+ ", user_email=" + user_email + "]";
	}
	
	
}