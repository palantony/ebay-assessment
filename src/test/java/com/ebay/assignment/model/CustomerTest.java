package com.ebay.assignment.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CustomerTest {

    @Test
    public void stripQuotesSucess() throws Exception {
    	String customerName ="Johnson, John";
    	String customerNameWithQuotes ="\""+"Johnson, John"+"\"";
        Customer customer = new Customer(customerNameWithQuotes,
                "Voorstraat 32",
                "3122gg",
                "020 3849381",
                "10000",
                "19870101");
      
        assertTrue("Quotes in name have been removed",customer.getName().equals(customerName));

    }

  

}