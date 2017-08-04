package com.swellwu.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.swellwu.po.Student;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springside.modules.utils.mapper.JsonMapper;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-08-04
 */
@Component("logsRecordConsumer")
public class LogsRecordConsumer implements ChannelAwareMessageListener  {

    public static final Logger LOG = Logger.getLogger(LogsRecordConsumer.class);
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String body = new String(message.getBody(), "utf-8");
        System.out.println("onMessage : body :" + JsonMapper.INSTANCE.fromJson(body, Student.class));
    }
}
