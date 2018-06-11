package com.ebay.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebay.assignment.util.ReturnPath;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET )
    public String home( Model model) {
        return ReturnPath.HOME_PAGE;
    }
	
}
