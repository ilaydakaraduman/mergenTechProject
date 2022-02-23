package com.proje.mergenTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "access")
@SpringBootApplication
public class MergenTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(MergenTechApplication.class, args);
	}

}
