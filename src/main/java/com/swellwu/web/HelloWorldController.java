package com.swellwu.web;

import com.swellwu.config.properties.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>hello world!</p>
 *
 * @author xinjian.wu
 * @date 2017-06-22
 */
@RestController
public class HelloWorldController {

    @Autowired
    BookProperties bookProperties;

    @GetMapping("/hello")
    public String helloworld(){
        return "Hello World!";
    }

    @GetMapping("/book")
    public String book(){
        return bookProperties.getDesc();
    }

    @GetMapping("/exception")
    public String exception(){
        List<Integer> list = new ArrayList<Integer>(10);
        System.out.println(list.get(11));
        return "ok";
    }
}
