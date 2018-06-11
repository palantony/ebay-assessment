package com.ebay.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ebay.assignment.model.FileTypeEnum;
import com.ebay.assignment.model.Workbook;
import com.ebay.assignment.services.CustomerService;
import com.ebay.assignment.util.ReturnPath;

@Controller
public class ReportController {

	@Autowired
	CustomerService customerService;

	@GetMapping(path = "/report")
	public String report(Model model) {
		populateViewWithWorkbooks(model);
		return ReturnPath.REPORT_PAGE;
	}

	private void populateViewWithWorkbooks(Model model) {
		Map<String, List<Workbook>> reportMap = customerService.getFiles();
		reportMap.forEach((k, v) -> {
			if (FileTypeEnum.CSV.toString().equalsIgnoreCase(k)) {
				model.addAttribute("cvsLoaners", (List<Workbook>) v);
			} else if (FileTypeEnum.PRN.toString().equalsIgnoreCase(k)) {
				model.addAttribute("prnLoaners", (List<Workbook>) v);
			}
		});

	}

}
