package com.toyfactory.mvcTest.controller;


import com.toyfactory.mvcTest.aop.LogExecutionTime;
import com.toyfactory.mvcTest.model.NestedObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    @LogExecutionTime
    public String sayHello() {

        return "Hello world!!";
    }


    @GetMapping("/delay/{time}")
    @ResponseBody
    @LogExecutionTime
    public String delay(@PathVariable int time) {

        try {
            Thread.sleep(time * 100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "delayed! " + time;
    }

    @GetMapping("/nestedObject")
    public NestedObject getNestedObject() {

        var result = new NestedObject();

        result.setName("test1");
        result.addSomeResult("100", "success");
        result.addSomeResult("200", "fail");

        return result;
    }
}
