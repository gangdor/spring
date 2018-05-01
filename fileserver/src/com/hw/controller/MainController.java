package com.hw.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	@RequestMapping("/fileupload.do")
	public void fileupload(Upload file) {
		System.out.println("fileupload");
		
		MultipartFile mf = file.getFile();
		String imgName = mf.getOriginalFilename();
		System.out.println(imgName);
		file.setName(imgName);
		byte[] data = null;
		FileOutputStream fo = null;
		try {
			data = mf.getBytes();
			fo = 
			new FileOutputStream("C:\\spring\\fileserver\\web\\img\\"+imgName);
			fo.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
