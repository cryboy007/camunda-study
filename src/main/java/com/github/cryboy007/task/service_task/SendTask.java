package com.github.cryboy007.task.service_task;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * @ClassName SendTask
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/23 16:53
 */
@Service("sendTask")
@Slf4j
public class SendTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("sendTask发送任务");
        RuntimeService runtimeService = execution.getProcessEngine().getRuntimeService();
        runtimeService.createMessageCorrelation("Message_test").correlate();
    }
}
