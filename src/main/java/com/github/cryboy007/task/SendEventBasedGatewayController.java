package com.github.cryboy007.task;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.engine.runtime.SignalEventReceivedBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendEventBasedGatewayController
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 15:19
 */
@RestController
@RequestMapping("/sendMsg")
@RequiredArgsConstructor
public class SendEventBasedGatewayController {
    private final RuntimeService runtimeService;
    @GetMapping("eventBasedMsgSend")
    public boolean eventBasedMsgSend() {
        SignalEventReceivedBuilder signalDirectLeader = runtimeService.createSignalEvent("Signal_direct_leader");
        signalDirectLeader.send();
        return true;
    }
}
