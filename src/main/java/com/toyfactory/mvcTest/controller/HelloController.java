package com.toyfactory.mvcTest.controller;


import com.toyfactory.mvcTest.aop.LogExecutionTime;
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
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "delayed! " + time;
    }
}
