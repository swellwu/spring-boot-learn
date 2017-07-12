package com.swellwu.taskexecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ${DESCRIPTION}
 *
 * @author swellwu
 * @create 2017-07-12-22:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AsyncTaskServiceTest {

    @Autowired
    private AsyncTaskService asyncTaskService;
    @Test
    public void test(){
        for(int i =0 ;i<100;i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }
}