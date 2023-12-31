package com.github.cryboy007.task;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @ClassName UserTaskExampl
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/5/21 10:09
 */
@RestController
@RequestMapping("/userTask")
@RequiredArgsConstructor
public class UserTaskExample {
    private final RuntimeService runtimeService;

    private final IdentityService identityService;

    //	Process_user_task
    @GetMapping("/start/{processKey}")
    public void start(@PathVariable("processKey") String processKey) {
        //指定人
        identityService.setAuthenticatedUserId("hetao");
//        //添加变量
//        Map<String,Object> variables = new HashMap<>();
//        variables.put("isFree",false);
        VariableMap variables = Variables.createVariables();
//        List<String> leaders = new LinkedList<>();
//        leaders.add("wangwu");
//        leaders.add("tony");
//        variables.put("leaders",leaders);
//        variables.put("originDays",10);
//        List<String> videoNames = new ArrayList<>();
//        videoNames.add("张三丰传奇");
//        variables.put("videoNames",videoNames);
        variables.putValue("videoNames", Arrays.asList("张三丰传奇","西游记","红楼梦"));
        runtimeService.startProcessInstanceByKey(processKey,variables);

    }
}
