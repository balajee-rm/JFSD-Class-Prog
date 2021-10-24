package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class URL_Control {

	@RequestMapping("/")
	@ResponseBody
    String home() {
      return "Hello World! -- This is a Home Page";
    }
	
	@RequestMapping("/jsppage")
    String jsppage(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	  model.addAttribute("name1", name);
	  return "welcome";
    }
	
}

