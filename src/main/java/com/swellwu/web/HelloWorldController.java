package com.swellwu.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>hello world!</p>
 *
 * @author xinjian.wu
 * @date 2017-06-22
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloworld(){
        return "Hello World!";
    }
}
