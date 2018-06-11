package com.ebay.assignment.parsers;

import org.springframework.stereotype.Component;

import com.ebay.assignment.model.Customer;

@Component
public class CsvFileParser extends FileParser {

	@Override
	Customer createLoanerFromLine(String line) {
		String[] column = line.split(",");// a CSV has comma separated lines
		return new Customer(column[0] + "," + column[1], column[2], column[3], column[4], column[5], column[6]);
	}

}
