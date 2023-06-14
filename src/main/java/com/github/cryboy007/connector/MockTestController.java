package com.github.cryboy007.connector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * @ClassName MockTestController
 * @Author tao.he
 * @email study.hetao@foxmail.com
 * @Since 2023/6/14 15:32
 */
@RestController
public class MockTestController {
    @GetMapping("testHttpConnector/{id}")
    public String getSex(@PathVariable Long id) {
        String s = id < 10 ? "男" : "女";
        return "{\"sex\": \"" + s + "\"}";
    }

    @GetMapping("scriptNotSupport")
    public boolean testScriptSupport() {
        ScriptEngineManager sem = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = sem.getEngineFactories();
        for (ScriptEngineFactory factory : factories)
            System.out.println(factory.getEngineName() + " " + factory.getEngineVersion() + " " + factory.getNames());
        if (factories.isEmpty())
            System.out.println("No Script Engines found");
        ScriptEngine engine = sem.getEngineByName("javascript");
        System.out.println(engine);
        return factories.isEmpty();
    }
}
