package com.scotia.test.testapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.scotia.test.model.FileContent;
import com.scotia.test.testapp.service.ScotiaTestService;

@RestController
@RequestMapping("/scotiatest")
public class ScotiaTestController {
	@Autowired
	ScotiaTestService scotiaTestService;

	// Method to accept and print params given in example only and one file
	@PostMapping(path = "/form", consumes = { "multipart/form-data" })
	@ResponseStatus(HttpStatus.OK)
	public String handleMultipart(@ModelAttribute FileContent content) throws Exception {
		return scotiaTestService.printAll(content);
	}
	
	
	// Method to accept and print any number of params and one file
	@PostMapping(path = "/formAll", consumes = { "multipart/form-data" })
	@ResponseStatus(HttpStatus.OK)
	public String handleMultipartver2(@RequestParam("thefile") MultipartFile  file, HttpServletRequest request) throws Exception {
		return scotiaTestService.printAllVer2(request.getParameterMap(),file);
	}
}
