package com.filess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilessApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilessApplication.class, args);

		try {
			Convertor.convertJsonToXmlAndSave("output.xml");
			System.out.println("XML file has been successfully created as output.xml");
		} catch (Exception e) {
			System.err.println("Error during conversion: " + e.getMessage());
		}
	}
}
