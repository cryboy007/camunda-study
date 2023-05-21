package com.github.cryboy007.listens;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName NoticeCustomerListerner
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 17:45
 */
@Component("NoticeCustomer")
@Slf4j
public class NoticeCustomerListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("进入通知客户任务");
        StringValue address = execution.getVariableLocalTyped("address");
        TimeUnit.SECONDS.sleep(1);
        log.info("你好,师傅正在赶往{},为你修理家电",address.getValue());
    }
}
