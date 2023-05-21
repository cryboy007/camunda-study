package com.github.cryboy007;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableProcessApplication("myCamundaStudyApplication")
@EnableScheduling
@ComponentScan(basePackages = {"com.github.cryboy007.task","com.github.cryboy007.config","com.github.cryboy007.listens"})
public class CamundaStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaStudyApplication.class, args);
	}

}
