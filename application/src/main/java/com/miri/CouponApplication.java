package com.miri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//NOTE: This class should be in a package that is a "root" package in all sub-projects

@SpringBootApplication
public class CouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponApplication.class, args);
	}
}

//TODO: split controller into 3 controllers: admin, company, customer
//TODO: convert Facades into classes
