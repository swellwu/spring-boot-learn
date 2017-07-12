package com.swellwu.event;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author swellwu
 * @create 2017-07-12-22:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoEventTest {

    @Autowired
    private DemoPublisher demoPublisher;

    @Test
    public void test(){
        Assert.assertTrue(demoPublisher!=null);
        demoPublisher.publish("demo event msg");
        System.out.println("demopublisher published!");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}