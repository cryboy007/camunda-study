package com.github.cryboy007.connector;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ConnectorSubScriptService
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/14 15:27
 */
@Configuration
@Slf4j
public class ConnectorSubScriptService {

    @Bean
    @ExternalTaskSubscription(topicName = "male_health_plan",lockDuration = 50000,processDefinitionKeyIn = {"Process_connector_test"} )
    public ExternalTaskHandler male_health_plan() {
        return (externalTask,  externalTaskService) -> {
            log.info("男士护理");
        };
    }


    @Bean
    @ExternalTaskSubscription(topicName = "female_health_plan",lockDuration = 50000,processDefinitionKeyIn = {"Process_connector_test"} )
    public ExternalTaskHandler female_health_plan() {
        return (externalTask,  externalTaskService) -> {
            log.info("女士护理");
        };
    }
}
