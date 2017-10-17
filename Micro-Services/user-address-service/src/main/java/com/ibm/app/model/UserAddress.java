package com.ibm.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ADDRESS",schema="test")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	@Column(name = "user_id", nullable = false, updatable = false)
	private String userid;
	
	@Column(name = "street", nullable = true, updatable = true)
	private String street;
	
	@Column(name = "city", nullable = true, updatable = true)
	private String city;
	
	@Column(name = "pin", nullable = true, updatable = true)
	private String pin;

	public Integer getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getPin() {
		return pin;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
