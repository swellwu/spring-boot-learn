package com.swellwu.mapper;

import com.swellwu.Application;
import com.swellwu.po.User;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wuxinjian on 2017/6/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@Transactional
@Rollback
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp(){
        userMapper.insert("AAA",22);
    }

    @Test
    public void findByName(){
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(22, u.getAge().intValue());
    }

    @Test
    public void cacheTest(){
        User u1 = userMapper.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());
        User u2 = userMapper.findByName("AAA");
        System.out.println("第一次查询：" + u2.getAge());
    }

}