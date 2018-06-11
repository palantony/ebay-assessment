package com.ebay.assignment.model;

import java.util.List;

import lombok.Data;

@Data
public class Workbook {

//    public enum DataSource {
//        CSV,
//        PRN
//    }

    final String source;
    final List<Customer> loaners;
//     DataSource sourceType;
 
}
