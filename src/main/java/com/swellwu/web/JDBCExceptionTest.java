package com.swellwu.web;

import com.swellwu.po.Student;
import com.swellwu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-27
 */
@RestController
public class JDBCExceptionTest {
    @Autowired
    private StudentService studentService;

    @GetMapping("/jdbc-exception")
    public String jdbcException(){
        studentService.insert(new Student("xxx",(byte)1,(byte)1));
        System.out.println("jdbcException()");
        return "ok";
    }
}
