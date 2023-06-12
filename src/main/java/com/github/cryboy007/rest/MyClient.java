package com.github.cryboy007.rest;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyClient
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/12 14:35
 */
@Component
public class MyClient {
    private final RuntimeService runtimeService;

    public MyClient(@Qualifier("remote") RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void start() {
        this.runtimeService
                .startProcessInstanceByKey("my_process_key");
    }

    public void correlate() {
        this.runtimeService
                .createMessageCorrelation("message_received")
                .processInstanceBusinessKey("WAIT_FOR_MESSAGE")
                .correlateAllWithResult();
    }
}
