package com.example;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity 
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
			joinColumns = @JoinColumn(name="USER_ID"))
	@GenericGenerator(name="sequence-gen",strategy="increment")
	@CollectionId(columns = { @Column (name = "ADDRESS_ID")}, generator = "sequence-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	
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

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}
