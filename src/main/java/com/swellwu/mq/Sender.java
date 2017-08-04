package com.swellwu.mq;

import com.swellwu.po.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springside.modules.utils.mapper.JsonMapper;

import java.util.Date;
/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-31
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        Student student = new Student("111");
        System.out.println("Sender : " + student);
        rabbitTemplate.convertAndSend("uc_common_logs", JsonMapper.INSTANCE.toJson(student));
    }
}
