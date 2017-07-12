package com.swellwu.config.aop;

import com.swellwu.po.Student;
import com.swellwu.service.StudentService;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-08
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LogsAspectTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void aopLogsTest(){
        Student student = new Student("李四",(byte)1,(byte)11);
        studentService.insert(student);
        studentService.getStudentById(student.getId());
    }

    @Test
    public void aopExceptionTest(){
        Student student = new Student(null,(byte)1,(byte)11);
        try {
            studentService.insert(student);
        }catch (Throwable t){
            ExceptionUtil.unwrapThrowable(t);
        }
    }
}