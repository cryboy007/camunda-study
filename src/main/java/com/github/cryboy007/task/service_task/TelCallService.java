package com.github.cryboy007.task.service_task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.value.IntegerValue;
import org.camunda.bpm.engine.variable.value.LongValue;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Service;

/**
 * @ClassName TelCallService
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 11:41
 */
@Service("telCall")
@Slf4j
public class TelCallService {

    public long doCall(DelegateExecution execution) {
        log.info("开始电话回访");
        StringValue name = execution.getVariableLocalTyped("repairManName");
        log.info("您对{}的服务打几分",name.getValue());
        return 10;
    }

    public void getScore(DelegateExecution execution) {
        log.info("查询评分");
        StringValue name = execution.getVariableLocalTyped("repairManName");
        LongValue score = execution.getVariableLocalTyped("score");
        log.info("顾客对{}的评分:{}",name.getValue(),score.getValue());
    }
}
