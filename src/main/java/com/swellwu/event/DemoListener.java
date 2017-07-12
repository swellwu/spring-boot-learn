package com.swellwu.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件订阅者
 *
 * @author swellwu
 * @create 2017-07-12-22:01
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("DemoListener receive msg: "+msg);
    }
}
