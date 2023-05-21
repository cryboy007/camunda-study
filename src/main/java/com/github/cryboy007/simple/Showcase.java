package com.github.cryboy007.simple;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Showcase
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/17 12:21
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class Showcase {
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    private String processInstanceId;

    @EventListener
    public void notify(final PostDeployEvent postDeployEvent) {
        processInstanceId = runtimeService.startProcessInstanceByKey("Sample").getProcessInstanceId();
        log.info("started instance: {}", processInstanceId);

        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();

        taskService.complete(task.getId());
        log.info("completed task: {}", task);
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }
}
