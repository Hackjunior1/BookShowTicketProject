package com.Package.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@Column(name="ADMIN_ID")
	//@NotNull
	private int id;
	
	@Column(name="ADMIN_MOBILE")
	private int mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public Admin(int id, int mobile) {
		super();
		this.id = id;
		this.mobile = mobile;
	}

	public Admin() {
		super();
	}
	
	
	

}
