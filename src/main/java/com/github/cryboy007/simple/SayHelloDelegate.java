package com.github.cryboy007.simple;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @ClassName SayHelloDelegate
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/17 14:00
 */
@Component
@Slf4j
public class SayHelloDelegate  implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("executed sayHelloDelegate:{}",delegateExecution);
    }
}
