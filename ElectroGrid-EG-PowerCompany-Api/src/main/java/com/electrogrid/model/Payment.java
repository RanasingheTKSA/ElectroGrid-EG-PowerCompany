package com.electrogrid.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	
	private int id;
	private String name;
	private String account_no;
	private String amount;
	private String card_no;
	private String security_code;
	private String expiration_date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getSecurity_code() {
		return security_code;
	}
	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	
@Override
public String toString() {
	return "Payment [id=" + id + ", name=" + name + ", account_no=" + account_no + ", amount="
			+ amount + ", card_no=" + card_no + ", security_code=" + security_code
			+ ", expiration_date=" + expiration_date + "]";
}

	
	
	

	
	
	

}
