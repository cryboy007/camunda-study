package com.github.cryboy007.external;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Invocation;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.client.variable.ClientValues;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HandlerConfiguration
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/17 14:45
 */
@Configuration
@Slf4j
public class HandlerConfiguration {

    @Bean
    @ExternalTaskSubscription("invoiceCreator")
    public ExternalTaskHandler invoiceCreatorHandler() {
        return (externalTask,externalTaskService) -> {
            String invoice = "123";

            // create an object typed variable with the serialization format XML
            ObjectValue invoiceValue = ClientValues
                    .objectValue(invoice)
                    .serializationDataFormat("application/xml")
                    .create();

            // add the invoice object and its id to a map
            Map<String, Object> variables = new HashMap<>();
            variables.put("invoiceId", 111);
            variables.put("invoice", invoiceValue);

            // select the scope of the variables
            boolean isRandomSample = Math.random() <= 0.5;
            if (isRandomSample) {
                externalTaskService.complete(externalTask, variables);
            } else {
                externalTaskService.complete(externalTask, null, variables);
            }

            log.info("The External Task {} has been completed!", externalTask.getId());
        };
    }

    @Bean
    @ExternalTaskSubscription(
            topicName = "invoiceArchiver",
            autoOpen = false
    )
    public ExternalTaskHandler invoiceArchiverHandler() {
        return (externalTask, externalTaskService) -> {
            TypedValue typedInvoice = externalTask.getVariableTyped("invoice");
            String value = (String)typedInvoice.getValue();
            log.info("Invoice on process scope archived: {}", value);
            externalTaskService.complete(externalTask);
        };
    }
}
