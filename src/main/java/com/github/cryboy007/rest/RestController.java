package com.github.cryboy007.rest;


import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName RestController
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/12 14:54
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final RuntimeService runtimeService;

    private final RepositoryService repositoryService;

    private final HistoryService historyService;

    public RestController(@Qualifier("remote") RuntimeService runtimeService,
                          @Qualifier("remote") RepositoryService repositoryService,
                          @Qualifier("remote") HistoryService historyService) {
        this.runtimeService = runtimeService;
        this.repositoryService = repositoryService;
        this.historyService = historyService;
    }

    @GetMapping("/test")
    public void test() {
        List<ProcessDefinition> definitions = this.repositoryService.createProcessDefinitionQuery().deploymentId("e50297b3-0670-11ee-aca7-3043d7edf505").list();
        for (ProcessDefinition definition : definitions) {
            System.out.println(definition.getKey() + ":" + definition.getVersion());
        }

        List<Deployment> deployments = this.repositoryService.createDeploymentQuery().deploymentId("e50297b3-0670-11ee-aca7-3043d7edf505").list();
        for (Deployment deployment : deployments) {
            System.out.println(deployment.getId() + ":" + deployment.getName());
        }

        List<ProcessInstance> instances = this.runtimeService.createProcessInstanceQuery().deploymentId("e50297b3-0670-11ee-aca7-3043d7edf505").list();
        for (ProcessInstance instance : instances) {
            System.out.println(instance.getId() + ":" + instance.getBusinessKey());
        }
    }
}
