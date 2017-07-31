package com.swellwu.config.redis;

import com.google.common.collect.Lists;
import com.swellwu.Application;
import com.swellwu.po.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springside.modules.utils.base.ObjectUtil;

import java.util.List;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-31
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    String key = "key";

    List<Student> list = Lists.newArrayList(new Student("张三丰",(byte)1,(byte)2),
            new Student("萧十一郎",(byte)11,(byte)22),new Student("乔峰",(byte)33,(byte)33));

    @Test
    public void test(){
        redisTemplate.boundValueOps(key).set(list);
        Object o = redisTemplate.boundValueOps(key).get();
        List<Student> list1 = (List<Student>) o;
        for (Student student : list1) {
            System.out.println(student);
        }
        Assert.assertArrayEquals(list1.toArray(),list.toArray());
    }
}
