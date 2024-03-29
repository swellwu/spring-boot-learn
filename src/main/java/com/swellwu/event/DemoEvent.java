package com.swellwu.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件定义
 *
 * @author swellwu
 * @create 2017-07-12-22:00
 */
public class DemoEvent extends ApplicationEvent{
    private static final long serialVersionUID = 1L;
    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
