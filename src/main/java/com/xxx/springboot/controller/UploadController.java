package com.xxx.springboot.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.xxx.springboot.http.ResponseData;

@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController {
	@PostMapping("/save")
	public ResponseData save(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
		try {
			if(!file.isEmpty()) {
				String dest = request.getSession().getServletContext().getRealPath("/")+"uploads/";
				String name = file.getOriginalFilename();
				File target = new File(dest+name);
				file.transferTo(target);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseData.create("ok");
	}
}
