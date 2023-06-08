package com.github.cryboy007.task.message_event;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.engine.variable.value.BooleanValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName MessageExternalTask
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 16:55
 */
@Configuration
@Slf4j
public class MessageExternalTask {

    @Bean
    @ExternalTaskSubscription(topicName = "wechat_external")
    public ExternalTaskHandler wechat() {
        return (externalTask,  externalTaskService) -> {
            log.info("getProcessDefinitionKey:{}",externalTask.getProcessDefinitionKey());
            log.info("微信支付start ...");
            externalTaskService.complete(externalTask);
            log.info("微信支付end ...");
        };
    }

    @Bean
    @ExternalTaskSubscription(topicName = "alipay_external")
    public ExternalTaskHandler alipay() {
        return (externalTask,  externalTaskService) -> {
            log.info("getProcessDefinitionKey:{}",externalTask.getProcessDefinitionKey());
            log.info("支付宝支付start ....");
            externalTaskService.complete(externalTask);
            log.info("支付宝支付end ....");
        };
    }
}
