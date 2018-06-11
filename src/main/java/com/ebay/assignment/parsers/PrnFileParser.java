package com.ebay.assignment.parsers;

import org.springframework.stereotype.Component;

import com.ebay.assignment.model.Customer;

@Component
public class PrnFileParser extends FileParser {

    @Override
    Customer createLoanerFromLine(String line) {
    	//@TODO Number tobe populated from property file
        String name = line.substring(0, 16).trim();
        String address = line.substring(16, 38).trim();
        String postcode = line.substring(38, 47).trim();
        String phone = line.substring(47, 62).trim();
        String creditLimit = line.substring(62, 74).trim();
        String birthday = line.substring(74).trim();
        return new Customer(name, address, postcode, phone, creditLimit, birthday);
    }
}
