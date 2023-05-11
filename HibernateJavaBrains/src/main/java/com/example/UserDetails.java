package com.example;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@Embedded
	private Address address;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name = "USER_NAME")
	public String getUserName() {
		return userName + " from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", address=" + address + "]";
	}

	
}
