package com.bway.springproject.controller;



import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {

	@RequestMapping(value="/gallery", method = RequestMethod.GET)
	public String displayImgs(Model model){
		
		model.addAttribute("imgList", Arrays.asList("04.jpg","003.jpg","01.jpg","02.jpg","002.jpg","004.jpg"));
		
		
		return "gallery";
	}
}
