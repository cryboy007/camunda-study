package com.github.cryboy007.task.service_task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName ReserveStart1
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 10:59
 */
@Slf4j
public class ReserveRepair implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("开始预约家电维修");
        String currentActivityName = execution.getCurrentActivityName();
        String processDefinitionId = execution.getProcessDefinitionId();
        log.info("当前活动名称:{},流程定义ID:{}",currentActivityName,processDefinitionId);
    }
}
