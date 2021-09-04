package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class URL_Control {
private Map<String, StudentDetails> st_map = new HashMap<>();
	
	public URL_Control() {
		StudentDetails st1 = new StudentDetails();
		st1.setId("1");
		st1.setFirstName("First");
		st1.setLastName("Student");
		st1.setCgpa((float) 9.6);
		st_map.put(st1.getId(), st1);
		
		StudentDetails st2 = new StudentDetails();
		st2.setId("2");
		st2.setFirstName("Second");
		st2.setLastName("Student");
		st2.setCgpa((float) 9.4);
		st_map.put(st2.getId(), st2);
	}
	
	@RequestMapping("/")
	@ResponseBody
    String home() {
      return "Hello World! -- This is a Home Page";
    }
	
	@RequestMapping("/students")
	@ResponseBody
    Map<String, StudentDetails> students() {
      return st_map;
    }
	
	@RequestMapping("/htmlpage1")
	@ResponseBody
    ModelAndView htmlpage1() {
	  ModelAndView view1 = new ModelAndView();
	  view1.setViewName("html/htmlpage.html");
      return view1;
    }

	@RequestMapping("/htmlpage2")
    String htmlpage2() {
	  return "html/htmlpage.html";
    }
	
	@RequestMapping("/jsppage")
    String jsppage(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	  model.addAttribute("name", name);
	  return "welcome";
    }

}
