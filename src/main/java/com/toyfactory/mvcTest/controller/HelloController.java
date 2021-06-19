package com.toyfactory.mvcTest.controller;


import com.toyfactory.mvcTest.aop.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    @LogExecutionTime
    public String sayHello(@RequestHeader Map<String, Object> reqHeader) {

       log.debug("[sayHello] request header:{}", reqHeader);

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
