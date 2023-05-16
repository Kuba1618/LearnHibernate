package com.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column (name="STREET_NAME") 
	private String street;
	@Column (name="CITY_NAME")
	private String cityName;
	@Column (name="STATE")
	private String state;
	@Column (name="PIN_CODE")
	private String pinCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", cityName=" + cityName + ", state=" + state + ", pinCode=" + pinCode
				+ "]";
	}
}
