package com.swellwu.taskscheduler;

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
 * @create 2017-07-12-22:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ScheduledTaskServiceTest {

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @Test
    public void test(){
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}