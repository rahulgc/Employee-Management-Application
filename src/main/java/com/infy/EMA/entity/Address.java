package com.infy.EMA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.infy.EMA.dto.AddressDTO;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String city;
	private String pincode;
	
	
	public Address(int addressId, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
	}


	public Address() {
		// TODO Auto-generated constructor stub
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pincode=" + pincode + "]";
	}
	public static AddressDTO prepareAddressDTO(Address ad) {
		AddressDTO a=new AddressDTO();
		a.setAddressId(ad.getAddressId());
		a.setCity(ad.getCity());
		a.setPincode(ad.getPincode());
		return a;
	}
	
	
	

}
