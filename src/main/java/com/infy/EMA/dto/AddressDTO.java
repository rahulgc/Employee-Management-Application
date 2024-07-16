package com.infy.EMA.dto;

import com.infy.EMA.entity.Address;

public class AddressDTO
 {
	private int addressId;
	private String city;
	private String pincode;
	
	public AddressDTO(int addressId, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
	}


	public AddressDTO() {
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
		return "AddressDTO [addressId=" + addressId + ", city=" + city + ", pincode=" + pincode + "]";
	}
	public static Address prepareAddress(AddressDTO ad) {
		Address a=new Address();
		a.setAddressId(ad.getAddressId());
		a.setCity(ad.getCity());
		a.setPincode(ad.getPincode());
		return a;
	}
	

}
