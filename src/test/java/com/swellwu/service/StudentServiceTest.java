package com.swellwu.service;

import com.swellwu.Application;
import com.swellwu.po.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-02
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@Transactional
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test(){
        Student student = new Student("张三丰",(byte)22,(byte)1);
        studentService.insert(student);
        studentService.getStudentById(student.getId());
        studentService.getStudentById(student.getId());
        studentService.insert(student);
        studentService.delete(student.getId());
    }
}