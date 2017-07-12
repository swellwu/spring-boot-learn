package com.swellwu.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * spring 多线程&并发机制
 *
 * @author swellwu
 * @create 2017-07-12-22:23
 */
@Service
public class AsyncTaskService  {

    @Async //1
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1："+(i+1));
    }
}
