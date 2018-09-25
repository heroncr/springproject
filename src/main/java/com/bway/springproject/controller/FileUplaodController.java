package com.bway.springproject.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUplaodController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String uploadPage(){
		
		return "fileuplaod";
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file,Model model) throws IOException{
		
		
		
		if(!file.isEmpty()){
			
			
			//Write in file
			
			FileOutputStream out = new FileOutputStream("D:\\java spring workspace\\springproject\\src\\main\\webapp\\resources\\imgs\\"+file.getOriginalFilename());
			out.write(file.getBytes());
			out.close();
			
		}
		
		model.addAttribute("msg" ,"File upload Success");
		
		return "fileuplaod";
	}
	
}
