package com.swellwu.mapper;

import com.swellwu.Application;
import com.swellwu.dao.UserService;
import com.swellwu.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
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
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void cacheTest1(){
        User user = new User("AAA",11);
        user = userService.insert(user);
        User user1 = userService.findById(user.getId());
        System.out.println("第一次查询：" + user1.getAge());
        userService.insert(user);
        User user2 = userService.findById(user.getId());
        System.out.println("第一次查询：" + user2.getAge());
    }

}