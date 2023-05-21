package com.github.cryboy007.task.service_task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * @ClassName DoingRepairService
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 11:38
 */
@Slf4j
@Service("doRepair")
public class DoingRepairService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("开始上门修理");
        String currentActivityName = execution.getCurrentActivityName();
        log.info("当前活动名:{}",currentActivityName);
        execution.setVariableLocal("repairManName","何涛");
    }
}
