package com.ebay.assignment.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.ebay.assignment.model.Customer;
import com.ebay.assignment.model.Workbook;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class FileParser  {

    public Workbook readFile(String source) {
    	List<Customer> loaners = null;
    	File file = new File(source);
    	Workbook workbook = null;
        try {
        	loaners = parseWorkbook(file);
        } catch (IOException e) {
            log.error("Failed to find workbook {}. Returning empty optional", source, e);
        }
        
        workbook = new Workbook(file.getName(),loaners);
        return workbook;
    }

    List<Customer> parseWorkbook(File file) throws IOException {
        try(BufferedReader br = Files.newBufferedReader(file.toPath(), Charset.forName("ISO-8859-1"))) {
            List<Customer> loaners = br.lines().skip(1).map( l -> {
                try {
                    return createLoanerFromLine(l);
                }catch (RuntimeException e) {
                    log.warn("Ignoring badly formatted line {}" , l, e);
                    return null;
                }
            }).filter(Objects::nonNull).collect(Collectors.toList());
            return loaners;
        }
    }

    abstract Customer createLoanerFromLine(String line);
    
   
}
