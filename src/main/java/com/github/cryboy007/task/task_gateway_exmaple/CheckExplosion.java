package com.github.cryboy007.task.task_gateway_exmaple;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName CheckExplosion
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 11:36
 */
@Service
@Slf4j
public class CheckExplosion implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String targetVideoName = (String) execution.getVariable("targetVideoName");
        log.info("视频名称:{},开始检测是否涉爆",targetVideoName);
    }
}
