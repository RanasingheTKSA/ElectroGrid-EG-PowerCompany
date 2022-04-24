package com.electrogrid.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Power {
	
	private int id;
	private String power_connection_type;
	private String power_bill_id;
	private String power_used_units;
	private String power_unit_value;
	private String power_pay_value;
	private String power_pay_balance;
	private String power_bill_value;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPower_connection_type() {
		return power_connection_type;
	}


	public void setPower_connection_type(String power_connection_type) {
		this.power_connection_type = power_connection_type;
	}


	public String getPower_bill_id() {
		return power_bill_id;
	}


	public void setPower_bill_id(String power_bill_id) {
		this.power_bill_id = power_bill_id;
	}


	public String getPower_used_units() {
		return power_used_units;
	}


	public void setPower_used_units(String power_used_units) {
		this.power_used_units = power_used_units;
	}


	public String getPower_unit_value() {
		return power_unit_value;
	}


	public void setPower_unit_value(String power_unit_value) {
		this.power_unit_value = power_unit_value;
	}


	public String getPower_pay_value() {
		return power_pay_value;
	}


	public void setPower_pay_value(String power_pay_value) {
		this.power_pay_value = power_pay_value;
	}


	public String getPower_pay_balance() {
		return power_pay_balance;
	}


	public void setPower_pay_balance(String power_pay_balance) {
		this.power_pay_balance = power_pay_balance;
	}


	public String getPower_bill_value() {
		return power_bill_value;
	}


	public void setPower_bill_value(String power_bill_value) {
		this.power_bill_value = power_bill_value;
	}


	@Override
	public String toString() {
		return "Power [id=" + id + ", power_connection_type=" + power_connection_type + ", power_bill_id=" + power_bill_id + ", power_used_units="
				+ power_used_units + ", power_unit_value=" + power_unit_value + ", power_pay_value=" + power_pay_value
				+ ", power_pay_balance=" + power_pay_balance + ", power_bill_value=" + power_bill_value + "]";
	}
	
	
}
