package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurrencyController {
	@Autowired
	Repository r;
	
	@GetMapping("/h2save/{from}/{to}/{rate}")
	@ResponseBody
	public String save(@PathVariable("from") String from,@PathVariable("to") String to,@PathVariable("rate") double rate){
		Currency c1 = new Currency();
		c1.setCfrom(from);
		c1.setCto(to);
		c1.setRate(rate);
		c1.setPort(8080);
		r.save(c1);
		
		return "Saved successfully";
	}
	@GetMapping("/h2show")
	@ResponseBody
	public List<Currency> display(){
		return r.findAll();
		
	}
	@GetMapping("/h2currency/{from}/{to}/")
	@ResponseBody
	public Currency getCurrency(@PathVariable("from") String from,@PathVariable("to") String to) {
		return r.findByCfromAndCto(from, to);
	}

}
