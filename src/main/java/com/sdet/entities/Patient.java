package com.sdet.entities;

public class Patient 
{
	int pId;
	String name;
	String email;
	String phone;
	String dob;
	public Patient(int pId, String name, String email, String phone, String dob){
		super();
		this.pId = pId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
