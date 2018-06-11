## Application is used to process files from given folder

## Validation :
	1) Reads only .csv & . prn files 
	2) process only if the file has following types .csv & .prn 
	
## Limitations :
	No Data validation is done, i.e read data from file and display raw data in html file

## Technologies 
  Spring boot, java , maven, bootstrap
  
## Prerequisite 
   Java 8, maven
   
## Steps to run the application
   <br/> Build : [maven build] 
   	mvn clean install <br/> <br/>
   Run : 
   	mvn spring-boot:run <br/> <br/>
   Checking : <br/>
    1) From browser hit url : http://localhost:8080/  [if port 8080 is used taken for other process, please update server.port in application.properties and rebuild the application ] <br/>
    2) Welcome page will be landed with "home" & "report" tabs<br/>
    3) Press "report" tab will populate data from csv & prn files under \inbound folder.<br/>
  
## TODO 
   Unit Testing is yet to be done. <br/>
   Validation : Header of csv & prn files to be validated before processing.<br/>
   Sequential flow of file process to be made as parallel using stream.<br/>


# BETest

## Why?

We are interested in your skills as a developer. As part of our assessment, we want to see your code.

## Instructions

In this repo, you'll find two files, Workbook2.csv and Workbook2.prn. These files need to be converted to a HTML format by the code you deliver. Please consider your work as a proof of concept for a system that can keep track of credit limits from several sources.

This repository is created specially for you, so you can push anything you like. Please update this README to provide instructions, notes and/or comments for us.

## The Constraints

Please complete the test within 5 business days. Use any language / libs / tools you like.

## Questions?

If you have any questions please send an email to DL-eCG-NL-assessment@ebay.com.

## Finished?

Please send an email to DL-eCG-NL-assessment@ebay.com let us know you're done.

Good Luck!


Copyright (C) 2001 - 2018 by Marktplaats BV an Ebay company. All rights reserved.
