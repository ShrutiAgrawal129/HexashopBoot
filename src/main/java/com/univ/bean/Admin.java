package com.univ.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String adminName;
	    private String password;
	    private String role; // Should be "ROLE_ADMIN"
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAdmin_name() {
			return adminName;
		}
		public void setAdmin_name(String admin_name) {
			this.adminName = admin_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "Admin [id=" + id + ", admin_name=" + adminName + ", password=" + password + ", role=" + role + "]";
		}
		public Admin(int id, String admin_name, String password, String role) {
			super();
			this.id = id;
			this.adminName = admin_name;
			this.password = password;
			this.role = role;
		}
		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	}

