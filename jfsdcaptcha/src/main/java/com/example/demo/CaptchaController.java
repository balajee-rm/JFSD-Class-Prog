package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.apiclub.captcha.Captcha;

@Controller
public class CaptchaController {

	@Autowired
	DaoService dao;
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping("/register")
	public String fun1(Model m) {
		User user = new User();
		Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
		user.setHiddenCaptcha(captcha.getAnswer());
		System.out.println(user.getHiddenCaptcha());
		user.setCaptcha(""); // value entered by the User
		System.out.println(user.getCaptcha());
		user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));
		System.out.println(user.getRealCaptcha());
		m.addAttribute("command", user);
		return "register";
	}
	
	@PostMapping("/save")
	public String fun2(@ModelAttribute User user, Model m) {
		System.out.println(user.getHiddenCaptcha());
		System.out.println(user.getCaptcha());
		dao.createUser(new User (user.getName(), user.getEmail()));
		//repo.save(user);
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String fun3(Model m) {
		List<User> l = dao.getAllUsers();
		//List<User> l = repo.findAll();
		System.out.println(l);
		m.addAttribute("command", l);
		return "listuser";
	}
	
}
