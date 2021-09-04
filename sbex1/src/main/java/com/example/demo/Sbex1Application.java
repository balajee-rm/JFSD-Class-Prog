package com.example.demo;

import java.util.HashMap;
import java.util.Map;
//import com.example.demo.StudentDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;

@SpringBootApplication
public class Sbex1Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	   return application.sources(Sbex1Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Sbex1Application.class, args);
	}

}
