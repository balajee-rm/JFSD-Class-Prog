package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String cfrom;
	String cto;
	double rate;
	int port;
	
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCfrom() {
		return cfrom;
	}
	public void setCfrom(String cfrom) {
		this.cfrom = cfrom;
	}
	public String getCto() {
		return cto;
	}
	public void setCto(String cto) {
		this.cto = cto;
	}

}
