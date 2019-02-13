package com.scotia.test.testapp.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.scotia.test.model.FileContent;

public interface ScotiaTestService {

	public String printAll(FileContent file);
	public String printAllVer2(Map<String, String[]> paramsList, MultipartFile thefile);
}
