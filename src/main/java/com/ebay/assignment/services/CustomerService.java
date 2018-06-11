package com.ebay.assignment.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ebay.assignment.model.FileTypeEnum;
import com.ebay.assignment.model.Workbook;
import com.ebay.assignment.parsers.CsvFileParser;
import com.ebay.assignment.parsers.FileParser;
import com.ebay.assignment.parsers.PrnFileParser;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class CustomerService {

    
    @Autowired
    CsvFileParser csvFileParser;
    
    @Autowired
    PrnFileParser prnFileParser;


    @Value("${inbound.file.path}")
    private String inboundPath;
 
    public Map<String,List<Workbook>>  getFiles(){
    	List<Workbook> csvData = new ArrayList<Workbook>();
    	List<Workbook> prnData = new ArrayList<Workbook>();
    	Map<String,List<Workbook>> reportMap = new HashMap<String,List<Workbook>>();
    	List<String> inboundFiles = null;
    	Workbook workbook = null;
    	String fileType =null;
    	List<String> unprocessedFiles = new ArrayList<String>();
    	
    	inboundFiles = getInboundFiles();
    	
    	for(String inboundFile : inboundFiles) {
    		fileType = FileTypeEnum.getValue(inboundFile.substring(inboundFile.lastIndexOf(".") + 1).toUpperCase()).toString();
    		workbook = null;
    		   switch (fileType) {
               case "CSV":
            	   workbook = csvFileParser.readFile(inboundFile);
            	   if(workbook !=null) {
            		   csvData.add(workbook);   
            	   }
                   break;
               case "PRN":
            	   workbook = prnFileParser.readFile(inboundFile);
            	   if(workbook !=null) {
            		   prnData.add(workbook);   
            	   }
                   break;
               default:
            	   //Capture files other than .csv,.prn and throw as non processed files
            	   unprocessedFiles.add(inboundFile);
           }
  
    	}
    	reportMap.put(FileTypeEnum.CSV.toString(), csvData);
    	reportMap.put(FileTypeEnum.PRN.toString(), prnData);
    	log.info("Number of files not processed : "+unprocessedFiles!=null ? Integer.toString(unprocessedFiles.size()) : "0");
    	return reportMap;
    		
    }


	private List<String> getInboundFiles() {
		List<String> inboundFiles = null;
		try {
    		inboundFiles = Files.list(Paths.get(inboundPath))
    		.map(Path::toFile)
    		.map(File::getAbsolutePath)
    		.collect(Collectors.toList());
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		return inboundFiles;
	}
   

}
