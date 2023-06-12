package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Currency,Integer>{
	public Currency findByCfromAndCto(String C_from,String C_to);
	
}
