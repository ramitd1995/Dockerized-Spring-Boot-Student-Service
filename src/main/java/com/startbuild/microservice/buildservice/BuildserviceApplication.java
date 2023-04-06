package com.startbuild.microservice.buildservice;

import com.startbuild.microservice.buildservice.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuildserviceApplication implements CommandLineRunner {

	@Autowired
	StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(BuildserviceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		studentDao.createTable();
	}
}
