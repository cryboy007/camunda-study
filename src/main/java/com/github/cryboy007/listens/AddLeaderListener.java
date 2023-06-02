package com.github.cryboy007.listens;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AddLeaderListener
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/24 11:38
 */
@Service("addLeaders")
@Slf4j
public class AddLeaderListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        log.info("开始添加审批人");
        List<String> leaders = new ArrayList<>();
        leaders.add("wangwu");
        leaders.add("tony");
        execution.setVariableLocal("leaders",leaders);
    }
}
