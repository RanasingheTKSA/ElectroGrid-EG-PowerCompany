package com.electrogrid.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Salary {
	
	private int id;
	private String full_name;
	private String nic;
	private String birthday;
	private String address;
	private String member_position;
	private String email;
	private String monthly_sal;
	private String working_hours;
	private String mobile_no;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMember_position() {
		return member_position;
	}
	public void setMember_position(String member_position) {
		this.member_position = member_position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMonthly_sal() {
		return monthly_sal;
	}
	public void setMonthly_sal(String monthly_sal) {
		this.monthly_sal = monthly_sal;
	}
	public String getWorking_hours() {
		return working_hours;
	}
	public void setWorking_hours(String working_hours) {
		this.working_hours = working_hours;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", full_name=" + full_name + ", nic=" + nic + ", birthday=" + birthday
				+ ", address=" + address + ", member_position=" + member_position + ", email=" + email + ", monthly_sal="
				+ monthly_sal + ", working_hours=" + working_hours + ", mobile_no=" + mobile_no + ", date=" + date + "]";
	}
	
	
	
	
	

}
