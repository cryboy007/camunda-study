package com.github.cryboy007.task.service_task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.DoubleValue;
import org.camunda.bpm.engine.variable.value.IntegerValue;
import org.springframework.stereotype.Service;

/**
 * @ClassName QueryAnnualLeaveService
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/23 14:59
 */
@Service("QueryAnnualLeaveService")
@Slf4j
public class QueryAnnualLeaveService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("进入查询剩余年假任务");
        DoubleValue leftAnnualDays = execution.getVariableLocalTyped("leftAnnualDays");
        log.info("剩余年假天数:{}",leftAnnualDays);
    }
}