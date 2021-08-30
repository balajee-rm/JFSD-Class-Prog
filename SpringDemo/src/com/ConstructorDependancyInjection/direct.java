package com.ConstructorDependancyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class direct {
	private int id;  
	private String name;  
	  
	public direct() {System.out.println("def cons");}  
	  
	public direct(int id) {this.id = id;}  
	  
	public direct(String name) {  this.name = name;}  
	  
	public direct(int id, String name) {  
	    this.id = id;  
	    this.name = name;  
	}  
	  
	void show(){  
	    System.out.println(id+" "+name);  
	}  
	
	public static void main(String[] args) {    
	    direct d = new direct(10);  
	    d.show();  
	}  
	
}


