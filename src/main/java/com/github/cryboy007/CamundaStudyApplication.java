package com.github.cryboy007;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableProcessApplication("myCamundaStudyApplication")
@EnableScheduling
public class CamundaStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaStudyApplication.class, args);
	}

}
