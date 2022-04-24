package com.electrogrid.model;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MonthlyBill {
	
	private int id;
	private String account_number;
	private String date;
	private String no_of_units;
	private String charge_of_the_month; 
	private String total_amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNo_of_units() {
		return no_of_units;
	}
	public void setNo_of_units(String no_of_units) {
		this.no_of_units = no_of_units;
	}
	public String getCharge_of_the_month() {
		return charge_of_the_month;
	}
	public void setCharge_of_the_month(String charge_of_the_month) {
		this.charge_of_the_month = charge_of_the_month;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	
	@Override
	public String toString() {
		return "MonthlyBil [id=" + id + ", account_number=" + account_number + ", date=" + date + ", no_of_units="
				+ no_of_units + ", charge_of_the_month=" + charge_of_the_month + ", total_amount=" + total_amount
				+ "]";
	}
	
	
}