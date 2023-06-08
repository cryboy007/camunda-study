package com.github.cryboy007.task.message_event;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.stereotype.Service;

/**
 * @ClassName HandlerOrder
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/2 17:00
 */
@Slf4j
@Service("handleOrder")
public class HandlerOrder implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("开始处理订单");
        //发消息
        RuntimeService runtimeService = execution.getProcessEngine().getRuntimeService();
        //判断是微信还是支付宝
        StringValue payMethod = execution.getVariableLocalTyped("endpoint");
        if (payMethod.getValue().equals("wechat")){
//            runtimeService.createMessageCorrelation("Message_wechat1");
            runtimeService.startProcessInstanceByMessage("Message_wechat1");
        }
        if (payMethod.getValue().equals("alipay")) {
//            runtimeService.createMessageCorrelation("Message_alipay1");
            runtimeService.startProcessInstanceByMessage("Message_alipay1");
        }
    }
}
