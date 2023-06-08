package com.github.cryboy007.task.message_event;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * @ClassName SuccessOrder
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 16:58
 */
@Service("successOrder")
@Slf4j
public class SuccessOrder implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("成功支付");
    }
}
