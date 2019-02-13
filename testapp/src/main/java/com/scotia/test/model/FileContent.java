package com.scotia.test.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileContent {
	private String fileid;
	private String description;
	private MultipartFile thefile;

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getThefile() {
		return thefile;
	}

	public void setThefile(MultipartFile thefile) {
		this.thefile = thefile;
	}

	

}
