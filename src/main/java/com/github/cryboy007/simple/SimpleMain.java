package com.github.cryboy007.simple;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.camunda.bpm.application.ProcessApplicationInterface;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.jobexecutor.JobExecutor;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.camunda.bpm.spring.boot.starter.event.PreUndeployEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @ClassName SimpleMain
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/17 14:01
 */
@Slf4j
@RequiredArgsConstructor
//@Component
public class SimpleMain implements CommandLineRunner {
    private final JobExecutor jobExecutor;
    private final HistoryService historyService;
    private final ConfigurableApplicationContext context;
    private final Showcase showcase;
    private final ProcessApplicationInterface application;
    private final ProcessEngine processEngine;

    private boolean exitWhenFinished ;

    boolean processApplicationStopped;

    @EventListener
    public void onPostDeploy(PostDeployEvent event) {
        log.info("postDeploy： {}",event);
    }

    @EventListener
    public void onPreUndeploy(PreUndeployEvent event) {
        log.info("preUndeploy: {}", event);
        processApplicationStopped = true;
    }

    @Scheduled(fixedDelay = 1500L)
    public void exitApplicationWhenProcessIsFinished() {
        Assert.isTrue(!((ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration()).isDbMetricsReporterActivate(),
                "Metrics reporter should be deactivated");

        String processInstanceId = showcase.getProcessInstanceId();

        if (processInstanceId == null) {
            log.info("processInstance not yet started!");
            return;
        }

        if (isProcessInstanceFinished()) {
            log.info("processinstance ended!");

            if (exitWhenFinished) {
                jobExecutor.shutdown();
                SpringApplication.exit(context, () -> 0);
            }
            return;
        }
        log.info("processInstance not yet ended!");
    }

    public boolean isProcessInstanceFinished() {
        final HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(showcase.getProcessInstanceId()).singleResult();

        return historicProcessInstance != null && historicProcessInstance.getEndTime() != null;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner#run() - {}", ToStringBuilder.reflectionToString(application, ToStringStyle.SHORT_PREFIX_STYLE));
    }
}
