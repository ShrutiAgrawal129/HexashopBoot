package com.univ.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private String name;
	private String address,email;
	private long phone;
	private String password,city;
	
	@Column(name = "role")
	private String role="USER";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", city=" + city + ", role=" + role + "]";
	}

	public Customer(String name, String address, String email, long phone, String password, String city, String role) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.city = city;
		this.role = role;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
