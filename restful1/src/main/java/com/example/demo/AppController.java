package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {
	
	@GetMapping("/")
	@ResponseBody
	public String fun1(@RequestParam(value = "name", defaultValue = "abcd") String name) {
		return ("hello world with " + name);
	}
	
	@GetMapping("/second/{name}")
	@ResponseBody
	public String fun2(@PathVariable("name") String name) {
		return ("second page with " + name);
	}
	
	@GetMapping("/welcome")
	public String fun3() {
		return "welcome";
	}

}
