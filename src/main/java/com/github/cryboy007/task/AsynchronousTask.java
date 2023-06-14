package com.github.cryboy007.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName AsynchronousTask
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/14 18:07
 */
public class AsynchronousTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        throw new RuntimeException("业务异常");
    }
}
