package com.swellwu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-06-22
 */
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloworld(){
        return "hello world!";
    }
}
