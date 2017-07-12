package com.swellwu.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springside.modules.utils.time.DateFormatUtil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 *
 * @author swellwu
 * @create 2017-07-12-22:38
 */
@Service
public class ScheduledTaskService {

    /**
     * 5s执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void fixedRateTest() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fixedRateTest 现在时间："+ DateFormatUtil.formatDate(DateFormatUtil.PATTERN_DEFAULT_ON_SECOND,new Date()));
    }

    /**
     * 间隔5s执行一次
     */
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayTest() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fixedDelayTest 现在时间："+ DateFormatUtil.formatDate(DateFormatUtil.PATTERN_DEFAULT_ON_SECOND,new Date()));
    }

    /**
     * 每天22：51执行
     */
    @Scheduled(cron = "0 51 22 ? * *"  )
    public void cronText(){
        System.out.println("cronText"+" 现在时间："+ DateFormatUtil.formatDate(DateFormatUtil.PATTERN_DEFAULT_ON_SECOND,new Date()));
    }
}
