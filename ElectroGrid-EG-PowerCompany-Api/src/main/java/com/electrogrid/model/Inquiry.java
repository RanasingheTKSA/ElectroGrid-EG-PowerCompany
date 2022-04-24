package com.electrogrid.model;


import jakarta.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	public class Inquiry {
		
		private int id;
		private String inquiry_number;
		private String inquiry_date;
		private String inquiry_type ;
		private String inquiry_description;
		public int getId() {
			return  id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getInquiry_number() {
			return inquiry_number;
		}
		public void setInquiry_number(String inquiry_number) {
			this.inquiry_number = inquiry_number;
		}
		public String getInquiry_date() {
			return inquiry_date;
		}
		public void setInquiry_date(String inquiry_date) {
			this.inquiry_date = inquiry_date;
		}
		public String getInquiry_type() {
			return inquiry_type;
		}
		public void setInquiry_type(String inquiry_type) {
			this.inquiry_type = inquiry_type;
		}
		public String getInquiry_description() {
			return inquiry_description;
		}
		public void setInquiry_description(String inquiry_description) {
			this.inquiry_description = inquiry_description;
		}
		
		@Override
		public String toString() {
			return "inquiry [id=" + id + ", inquiry_number=" + inquiry_number + ", inquiry_date=" +inquiry_date + ", inquiry_type="
					+ inquiry_type + ", inquiry_description=" + inquiry_description +"]";
		}
		

}
