package com.github.cryboy007.external;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.SpringTopicSubscription;
import org.camunda.bpm.client.spring.event.SubscriptionInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName SubScriptions
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/17 14:56
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class Subscriptions implements ApplicationListener<SubscriptionInitializedEvent> {
    private final SpringTopicSubscription invoiceCreatorHandlerSubscription;

    public final SpringTopicSubscription invoiceArchiverHandlerSubscription;

    //初始化后可以打开或关闭订阅
    @Override
    public void onApplicationEvent(SubscriptionInitializedEvent event) {
        SpringTopicSubscription springTopicSubscription = event.getSource();
        String topicName = springTopicSubscription.getTopicName();

        log.info("Subscription with topic name '{}' initialized", topicName);
        if (!springTopicSubscription.isOpen()) {
            log.info("Subscription with topic name '{}' not yet opened", topicName);

            // do something before subscription is opened

            springTopicSubscription.open();

            log.info("Subscription with topic name '{}' opened", topicName);

            springTopicSubscription.close();

            log.info("Subscription with topic name '{}' temporarily closed", topicName);

            // do something with subscription temporarily closed

            springTopicSubscription.open();

            log.info("Subscription with topic name '{}' reopened again", topicName);
        }
    }

    @PostConstruct
    public void listSubscriptionBeans() {
        log.info("Subscription bean 'invoiceCreatorHandlerSubscription' has topic name: {} ",
                invoiceCreatorHandlerSubscription.getTopicName());
        log.info("Subscription bean 'invoiceArchiverHandlerSubscription' has topic name: {} ",
                invoiceArchiverHandlerSubscription.getTopicName());
    }

}
