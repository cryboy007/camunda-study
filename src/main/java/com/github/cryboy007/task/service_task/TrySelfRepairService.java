package com.github.cryboy007.task.service_task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.value.BooleanValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TrySelfRepairSerivce
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 15:30
 */
@Configuration
@Slf4j
public class TrySelfRepairService {
    @Bean
    @ExternalTaskSubscription(topicName = "try_self_repair",lockDuration = 50000,processDefinitionKeyIn = {"Process_external_task"} )
    public ExternalTaskHandler doSelfRepair() {
        return (externalTask,  externalTaskService) -> {
            log.info("getProcessDefinitionKey:{}",externalTask.getProcessDefinitionKey());
            log.info("尝试自修程序");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BooleanValue isFree = externalTask.getVariableTyped("isFree");
            if (isFree.getValue()) {
                log.info("免费维修");
                externalTaskService.handleFailure(externalTask,"自己维修好了,不用付费维修了","这里可以打印具体堆栈",0,5000);
            }else {
                log.info("付费维修,走到下一个任务");
                externalTaskService.complete(externalTask);
            }
        };
    }
}
