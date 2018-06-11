package com.ebay.assignment.model;

import lombok.ToString;


@ToString
public class Customer {
	public final String name;

    public final String address;

    public final String postcode;

    public final String phone;

    public final String creditLimit;

    public final String birthday;


    public Customer(String name, String address, String postcode, String phone, String creditLimit, String birthday) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.creditLimit = creditLimit;
        this.birthday = birthday;
    }

    public String getName(){
    	return (name != null && !name.isEmpty()) ? (name.toString().replaceAll("\"", "")) : "";
    }


}
