package com.scotia.test.testapp.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.scotia.test.model.FileContent;
import com.scotia.test.testapp.service.ScotiaTestService;

@Service
public class ScotiaTestServiceImpl implements ScotiaTestService {

	@Override
	public String printAll(FileContent fileContent) {

		StringBuffer toReturn = new StringBuffer();
		if (fileContent != null) {

			toReturn.append(fileContent.getFileid());
			toReturn.append("\n");
			toReturn.append(fileContent.getDescription());
			toReturn.append("\n");
			try {
				if (null != fileContent.getThefile()) {

					InputStream fis = fileContent.getThefile().getInputStream();
					int content;
					while ((content = fis.read()) != -1) {
						toReturn.append((char) content);
					}
				} else {
					System.out.println("No file uploaded");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(toReturn);
		} else {
			System.out.println("No Data");
		}

		return toReturn.toString();
	}

	@Override
	public String printAllVer2(Map<String, String[]> paramsMap, MultipartFile thefile) {
		StringBuffer toReturn = new StringBuffer();
		if (paramsMap != null && !paramsMap.isEmpty()) {
			paramsMap.values().stream().forEachOrdered(s -> {
				Arrays.asList(s).stream().forEachOrdered(z -> {
					toReturn.append(z);
					toReturn.append("\n");
				});

			});
			;
		}
		try {
			if (null != thefile) {

				InputStream fis = thefile.getInputStream();
				int content;
				while ((content = fis.read()) != -1) {
					toReturn.append((char) content);
				}
			} else {
				System.out.println("No file uploaded");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(toReturn);
		return toReturn.toString();
	}

}
