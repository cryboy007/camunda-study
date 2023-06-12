package com.github.cryboy007;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.community.rest.EnableCamundaRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableProcessApplication("myCamundaStudyApplication")
@EnableScheduling
@ComponentScan(basePackages = {"com.github.cryboy007.task","com.github.cryboy007.config",
		"com.github.cryboy007.listens","com.github.cryboy007.rest"})
@EnableCamundaRestClient
public class CamundaStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaStudyApplication.class, args);
	}

}
