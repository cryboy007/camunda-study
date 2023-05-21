package com.github.cryboy007.listens;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Component;

/**
 * @ClassName CheckHomeAddressListener
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 17:38
 */
@Component("checkHomeAddress")
@Slf4j
public class CheckHomeAddressListener implements ExecutionListener {
    private final String DEFAULT_ADDRESS = "广东省广州市天河区";

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("检查家庭住址监听器执行");
        StringValue address = execution.getVariableLocalTyped("address");
        if (address == null) {
            execution.setVariable("address",DEFAULT_ADDRESS);
        }
    }
}
