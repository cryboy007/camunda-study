package com.github.cryboy007.task.task_gateway_exmaple;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * @ClassName CheckAbroadIp
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 11:37
 */
@Slf4j
@Service
public class CheckAbroadIp implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("开始校验是否境外IP");
    }
}
