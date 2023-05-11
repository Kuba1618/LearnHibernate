package com.example;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
	@AttributeOverrides({
		@AttributeOverride (name = "street", column = @Column(name="HOME_STREET_NAME")),
		@AttributeOverride (name = "cityName", column = @Column(name="HOME_CITY_NAME")),
		@AttributeOverride (name = "state", column = @Column(name="HOME_STATE_NAME")),
		@AttributeOverride (name = "pinCode", column = @Column(name="HOME_PIN_CODE"))
	})
	
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", homeAddress=" + homeAddress  
				+ ", officeAddress= " + officeAddress + "]";
	}
	
}
