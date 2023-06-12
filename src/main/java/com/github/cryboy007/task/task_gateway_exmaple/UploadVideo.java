package com.github.cryboy007.task.task_gateway_exmaple;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName UploadVideo
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 11:38
 */
@Service
@Slf4j
public class UploadVideo implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String result = (String) execution.getVariable("result");
        log.info("开始上传视频,上传结果::{}",  result);
    }
}
