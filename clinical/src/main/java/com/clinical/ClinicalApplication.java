package com.clinical;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ClinicalApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("clinical/log4j.properties");
		SpringApplication.run(ClinicalApplication.class, args);
	}

}
