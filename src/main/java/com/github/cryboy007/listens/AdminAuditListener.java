package com.github.cryboy007.listens;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminAuditListener
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/24 11:37
 */
@Service("adminAudit")
@Slf4j
public class AdminAuditListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("admin账户批准了");
    }
}
