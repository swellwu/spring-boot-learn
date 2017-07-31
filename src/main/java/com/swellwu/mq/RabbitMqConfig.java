package com.swellwu.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-07-31
 */
@Component
public class RabbitMqConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
