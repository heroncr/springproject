package com.bway.springproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.HomeController;
import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.daos.UserDao;
import com.bway.springproject.models.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserDao udao;
	@Autowired
	private StudentDao sdao;
	
	
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	public String  getLoginForm(){
		
		logger.info("inside login page method");
		
		
		return "login";
	}
	
	@RequestMapping(value="/userlogin", method=RequestMethod.POST)
	public String isExist(@ModelAttribute User user, Model model, HttpServletRequest req, HttpSession session) throws IOException{
		
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		String input = req.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(input);
		
		if(verify){
			
		if(udao.login(user.getUsername(), user.getPassword())){
		
			logger.info("Login Success");
			
			session.setAttribute("username", user.getUsername());
			session.setMaxInactiveInterval(10 * 60);
		model.addAttribute("user", user.getUsername());	
		
		model.addAttribute("slist", sdao.getAll());
		
		return "home";
	}else{
		
		model.addAttribute("error", "user doesnot exist");
		logger.info("Login Failed");
		return "login";
	}
		
		}
		model.addAttribute("error", "you are not Human");
		
		logger.info("Login Failed");
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET )
	public String logout(HttpSession session){
		logger.info("user logout sucsess");
		session.invalidate();
		return "login";
	}


}

