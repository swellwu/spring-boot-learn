package com.swellwu.mapper;

import com.swellwu.Application;
import com.swellwu.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wuxinjian on 2017/6/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserMapperTest {

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByName(){
        User u = userMapper.findByName("AAA");
        Assert.assertTrue(u!=null);
    }

    @Test
    public void cacheTest(){
        User u1 = userMapper.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());
        User u2 = userMapper.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }

}